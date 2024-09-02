import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeInOrderIterator implements Iterator {
	private Stack stack;

	public BinaryTreeInOrderIterator(BinaryNode root) {
		stack = new StackAsDynamicArray();
		prepareNext(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	// Returns the next element in the iteration.
	public Object next() {
		if (!hasNext())
			throw new IllegalArgumentException();
		BinaryNode node = (BinaryNode) stack.pop();
		prepareNext(node.right);
		return node.data;
	}

	private void prepareNext(BinaryNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

}
