package HW7;
public class NodeBSTTest {

	public static void main(String[] args) {
		
		// create a binary search tree that stores integers
		NodeBST<Integer> t =   new NodeBST<>();

		t.add(t.root, 100);
		t.add(t.root, 50);
		t.add(t.root, 150);
		t.add(t.root, 70);
		System.out.println("Print tree horizontally: \n" );
		t.print(t.root);
	}

}
