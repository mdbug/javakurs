package algo.blatt06;

import java.util.Random;

/**
 * Binaerer Suchbaum, der int-Werte enthaelt
 *
 */
public class BinTree {

	private TreeNode root = null;

	public BinTree(int[] values) {
	    for (int k : values) {
	        insert(k);
        }
    }

    public int getNodeCount() {
	    return getNodeCount(root);
    }

    public int getNodeCount(TreeNode root) {
	    if (root == null)
	        return 0;

	    return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }

    public String toString() {
	    return toString(root);
    }

    public String toString(TreeNode root) {
	    if (root == null)
	        return "";
	    return toString(root.left) +  " "  + root.data +  " " + toString(root.right);
    }

    public int getHeight() {
	    return getHeight(root) - 1;
    }

    public int getHeight(TreeNode root) {
	    if (root == null)
	        return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public boolean isComplete() {
	    return isComplete(root);
    }

    public boolean isComplete(TreeNode root) {
        return root != null && (isComplete(root.left) == isComplete(root.right));
    }

    public boolean isAVL() {
	    return isAVL(root);
    }

    public boolean isAVL(TreeNode node) {
	    if (node == null)
	        return true;
	    int balance =  Math.abs(getHeight(node.left) - getHeight(node.right));
	    return balance < 2 && isAVL(node.left) && isAVL(node.right);
    }

    public BinTree(int count, int min, int max) {
	    Random rnd = new Random();
	    for (int i = 0; i < count; ++i) {
	        boolean fail;
	        do {
                fail = false;
                try {
                    insert(rnd.nextInt(max + 1 - min) + min);
                } catch( ArithmeticException e ) {
                    fail = true;
                }
            } while (fail);
        }
    }

	/**
	 * Sucht nach dem Wert x im Baum (iterativ)
	 * 
	 * @param x Der zu suchende Wert.
	 * @return den Kante, der den Wert x beinhaltet oder null,
	 * falls x nicht im Baum vorhanden ist.
	 */
	public TreeNode getNode(int x) {
		TreeNode node = root;
		while (node != null) {
			if (node.data == x)
				break;
			if (x < node.data) // links suchen
				node = node.left;
			else
				node = node.right; // rechts suchen
		}
		return node; // nicht gefunden->null zurueckgeben
	}

	/**
	 * Prueft, ob der Wert n im Baum vorhanden ist.
	 * 
	 * @param n Der zu pruefende Wert.
	 * @return true, falls der Kante im Baum vorhanden ist, sonst false.
	 */
	public boolean contains(int n) {
		return getNode(n) != null;
	}

	/**
	 * Fuegt den Wert n in den Baum ein
	 * 
	 * @param n Der einzufuegende Wert
	 * @throws ArithmeticException, falls der Wert schon im Baum vorkommt.
	 */
	public void insert(int n) {
		if (root == null) { // Baum leer
			root = new TreeNode(null, null, n);
			return;
		}
		TreeNode node = root;
		while (node.data != n) {
			if (n < node.data) {
				if (node.left == null) { // links frei
					node.left = new TreeNode(null, null, n);
					return;
				} else // links weitersuchen
					node = node.left;
			} else {
				if (node.right == null) { // rechts frei
					node.right = new TreeNode(null, null, n);
					return;
				} else // rechts weitersuchen
					node = node.right;
			}
		}
		throw new ArithmeticException("Wert schon im Baum enthalten!");
	}

	/**
	 * Loeschen aller Daten
	 */
	public void clear() {
		root = null;
	}
}
