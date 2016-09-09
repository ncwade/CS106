// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."


public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    // Added for Homework problem 1
    public int countLeftNodes() {
    	return countLeftNodes(overallRoot);
    }

    private int countLeftNodes(IntTreeNode nd) {
        int leftNodes = 0;
        if (nd.left != null) {
            leftNodes += 1 + countLeftNodes(nd.left);
        }

        if (nd.right != null) {
            leftNodes += countLeftNodes(nd.right);
        }

        return leftNodes;
    }
    
    // Added for Homework problem 5
    public void printLevel(int level) {
    	if(level < 1) {
    		throw new IllegalArgumentException();
    	}
    	int currentLevel = 1;
    	printLevel(overallRoot,level,currentLevel);
    }

    private void printLevel(IntTreeNode node, int level, int currentLevel) {
    	if(level == currentLevel) {
    		System.out.println(node.data);
    	} else {
    		printLevel(node.left,level,currentLevel+1);
    		printLevel(node.right,level,currentLevel+1);
        }   
    }
    
    // Added for Homework problem 7
    public boolean isFull() {
    	boolean full = true;
    	isFull(overallRoot,full);
    	return full;
    }

    public void isFull(IntTreeNode node, boolean isFull) {
    	if(node.left != null) {
    		isFull(node.left, isFull);
    	}
    	
    	if (node.right != null) {
    		isFull(node.right, isFull);
    	}
    	
    	if((node.right == null && node.left != null) && (node.left == null && node.right != null)) {
    		isFull = false;
    	}
    }

    // Added for homework problem 9
    public boolean equals(IntTree tree) {
    	return equals(overallRoot, tree.overallRoot);
    }

	private boolean equals(IntTreeNode tree1, IntTreeNode tree2) {
        if(tree1 == null && tree2 == null) {
        	return true;
        } else if (tree1 == null || tree2 == null) {
        	return false;
    	}else if (tree1.data != tree2.data) {
        	return false;
        }

        return equals(tree1.left,tree2.left) && equals(tree1.right,tree2.right);
    }
	
	// Added for homework problem 15
	public void trim (int min, int max) {
	    overallRoot = shears (overallRoot, min, max);
	}

	private IntTreeNode shears (IntTreeNode root, int min, int max) {
	    if (root == null) {
	        return root;
	    }

	    if(root.data <= max && root.data>= min) {
	        root.left = shears(root.left, min, max);
	        root.right = shears (root.right, min, max);
	        return root;
	    }else if (root.data < min) {
	        return shears (root.right, min, max);
	    }else if (root.data > max) {
	        return shears(root.left, min, max);
	    }else{
	        return root;
	    }
	}
	
	// Added for homework problem 20
	public void makePerfect() {
		makePerfect(overallRoot,getHeight(overallRoot),1);
	}
	
	private void makePerfect(IntTreeNode root, int goal, int current) {
		
		if(root.left == null)
			root.left = new IntTreeNode(0);
		if(root.right == null)
			root.right = new IntTreeNode(0);
		
		if(goal > current) {
			makePerfect(root.left,goal,current+1);
			makePerfect(root.left,goal,current+1);
		}
	}
	
	private int getHeight(IntTreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left),getHeight(root.right));
	}
	
}