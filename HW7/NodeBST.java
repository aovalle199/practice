package HW7;
//import net.datastructures.DefaultComparator;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Comparator;

// binary search tree
public class NodeBST<E> extends NodeBinaryTree<E> {

	private Comparator<E> comp;
	private int size = 0;
	
	public NodeBST(Comparator<E> c) {comp = c;};
	public NodeBST(){ this(new DefaultComparator<E>()); }
	
	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }
	public void resetTree() { root = null; size = 0;}

	// Add a new node to an empty tree
	// In parameter e: element of a new node, which becomes the root
	// Output: root node
	public Node<E> addRoot(E e) throws IllegalStateException {
	    if (size != 0) throw new IllegalStateException("Tree is not empty");
	    root = createNode(e, null, null, null);
	    size = 1;
	    return root;
	}

	// Add a new node to a tree
	// In parameter n: root of the subtree to which new node is added
	// In parameter e: element of the new node to be added
	// Output: the node that was added

	public Node<E> add(Node<E> n, E e){
		Node<E> x = n;
		Node<E> y = x;
		Node<E> temp = null;
		Node<E> parent = null;
		Node<E> left = null;
		Node<E> right = null;
		// if the tree is empty add the root
		if (n == null) {
			root = addRoot(e);
			return root;

		}
		// While the tree is not empty execute
		while (x != null) {
			// if the element at x is the same as e return null
			if (comp.compare(x.getElement(), e) == 0) {
				return null;
			}
			// if the element at x is greater than e execute
			else if (comp.compare(x.getElement(), e) > 0) {
				// set y at the same location as x and get the left side of the current node of x
				y = x;
				x = x.getLeft();
			}
			// if not, continue down the right node
			else {
				y = x;
				x = x.getRight();
			}
		}
		// create a node with the parent, left, right and e (element) because x doesn't have
		// any children
		temp = createNode(e, parent, left, right);
		// then temp become the left child of y
		temp.setParent(y);
		if (comp.compare(y.getElement(), e) > 0) {
			y.setLeft(temp);
			size++;
		}
		// if the element is not greater than e, then set the child to the right
		else {
			y.setRight(temp);
			size++;
		}
		return temp;
	}


	// Print a binary tree horizontally
	// Modified version of https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	// Modified by Keith Gutfreund
	// In parameter n: the root of the subtree to be printed

	void print(Node<E> n){ 
		print ("", n); 
	}
	
	private void print(String prefix, Node<E> n){
	  if (n != null){
	    print(prefix + "       ", right(n));
	    System.out.println (prefix + ("|-- ") + n.getElement());
	    print(prefix + "       ", left(n));
	  }
	}
	
	// Print nodes by inorder tree traversal
	public void inorderPrint(Node<E> n){
		if (n == null) return;
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}

}
