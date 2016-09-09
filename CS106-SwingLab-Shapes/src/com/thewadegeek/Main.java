package com.thewadegeek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

public class Main {
	final static int HEIGHT = 800;
	final static int WIDTH = 900;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("CS206 Swing Lab");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container pane = frame.getContentPane();
				pane.setLayout(new BorderLayout());
				
				// Create components.
				JComboBox<Shape> lShapeBox = new JComboBox<Shape>();
				JComboBox<Color> lBorderColors = new JComboBox<Color>();
				JComboBox<Color> lFillColors = new JComboBox<Color>();
				lShapeBox.addItem(new Rectangle(0,0,100,100));
				lShapeBox.addItem(new Triangle(0,0,100,100));
				lShapeBox.addItem(new Ellipse(0,0,100,100));
				lBorderColors.addItem(Color.RED);
				lBorderColors.addItem(Color.GREEN);
				lBorderColors.addItem(Color.BLUE);
				lFillColors.addItem(Color.RED);
				lFillColors.addItem(Color.GREEN);
				lFillColors.addItem(Color.BLUE);
				JCheckBox selectMode = new JCheckBox("Select Mode");
				JButton clearData = new JButton("Clear all");
				ShapeList shapeList = new ShapeList();
				
				JLabel mouseCoordinatesLabel = new JLabel();
				JLabel mouseLocationLabel = new JLabel();
				Border border = LineBorder.createGrayLineBorder();
				mouseCoordinatesLabel.setBorder(border);
				mouseLocationLabel.setBorder(border);

				// Build top frame.
				JPanel topPanel = new JPanel();
				topPanel.add(clearData);
				topPanel.add(lShapeBox);
				topPanel.add(lBorderColors);
				topPanel.add(lFillColors);
				topPanel.add(selectMode);
				
				// Build bottom frame.
				JPanel bottomPanel = new JPanel();
				bottomPanel.add(mouseCoordinatesLabel);
				bottomPanel.add(mouseLocationLabel);
				
				// Build center frame.
				JPanel centerPanel = new JPanel(null);
				
				clearData.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						centerPanel.removeAll();
						centerPanel.repaint();
						shapeList.clear();
					}
				});
				
				// Mouse Handlers
				centerPanel.addMouseMotionListener(new MouseInputAdapter() {
					public void mouseMoved(MouseEvent me) {
						mouseCoordinatesLabel.setText(me.getPoint().toString());
						for(Component item : centerPanel.getComponents()) {
							if(item instanceof Shape) {
								mouseLocationLabel.setText("Mouse In Shape: "+item.contains(me.getPoint()));
								if(item.contains(me.getPoint())) {
									break;
								}
							}
						}
					}
				});

				centerPanel.addMouseListener(new MouseInputAdapter() {
					public void mouseClicked(MouseEvent me) {
						centerPanel.removeAll();
						if(selectMode.isSelected()) {
							shapeList.toTop(me.getPoint());
						} else {
							Shape shape = null;
	
							if((Shape)lShapeBox.getSelectedItem() instanceof Rectangle) {
								shape = new Rectangle(me.getX(),me.getY(),100,100);	
							} else if ((Shape)lShapeBox.getSelectedItem() instanceof Triangle) {
								shape = new Triangle(me.getX(),me.getY(),100,100);	
							} else {
								shape = new Ellipse(me.getX(),me.getY(),100,100);
							}
							shape.setBackground((Color) lFillColors.getSelectedItem());
							shape.setBorder((Color)lBorderColors.getSelectedItem());
							shapeList.add(shape);
						}

						for(Shape shape : shapeList) {
							centerPanel.add(shape);
						}
						centerPanel.repaint();
					}
				});
				centerPanel.setSize(WIDTH, HEIGHT);
				centerPanel.setBorder(border);

				// Add all of the subframes to the main frame.
				frame.add(topPanel,BorderLayout.NORTH);
				frame.add(centerPanel, BorderLayout.CENTER);
				frame.add(bottomPanel,BorderLayout.SOUTH);
				frame.setSize(WIDTH, HEIGHT);
				frame.setResizable( false );
				frame.setVisible(true);
			}
		});
	}
}
