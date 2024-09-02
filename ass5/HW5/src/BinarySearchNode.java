import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchNode extends BinaryNode {

	private Comparator treeComparator;

	public BinarySearchNode(Object data, Comparator myComparator) {
		super(data);
		this.treeComparator = myComparator;
	}

	public BinarySearchNode(BinarySearchNode otherTreeRoot, Iterator otherTreeIterator) {
		super("dummy");
		treeComparator = otherTreeRoot.getComparator();
		buildPerfectTree(otherTreeRoot.size());
		fillTheNodes(this, otherTreeIterator);
	}

	// element is an Entry with one "dummy" field
	public Object findData(Object element) {
		if (treeComparator.compare(data, element) > 0) {
			if (left != null)
				return ((BinarySearchNode) left).findData(element);
			else
				return null;
		} else if (treeComparator.compare(data, element) < 0) {
			if (right != null)
				return ((BinarySearchNode) right).findData(element);
			else
				return null;
		} else
			return this.data;
	}

	public Object findMin() {
		BinaryNode currNode = this;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.data;
	}

	// Complete the following methods:

	private void buildPerfectTree(int size) {
		Queue Q = new QueueAsLinkedList();
		Q.enqueue(this);
		int n = 1;
		while (n < size) {
			BinarySearchNode DummyL = new BinarySearchNode("dummy", this.treeComparator);
			BinarySearchNode Next = (BinarySearchNode) Q.dequeue();
			Next.left = DummyL;
			Q.enqueue(DummyL);
			n = n + 1;
			if (n < size) {
				BinarySearchNode DummyR = new BinarySearchNode("dummy", this.treeComparator);
				Next.right = DummyR;
				Q.enqueue(DummyR);
				n = n + 1;
			}
		}
	}

	private void fillTheNodes(BinarySearchNode root, Iterator treeIterator) {
		if (treeIterator.hasNext()) {
			if (root.left != null) {
				fillTheNodes((BinarySearchNode) root.left, treeIterator);
			}
			root.data = treeIterator.next();
			if (root.right != null) {
				fillTheNodes((BinarySearchNode) root.right, treeIterator);
			}
		}
	}

	public Comparator getComparator() {
		return this.treeComparator;
	}

	public void insert(Object toInsert) {
		if (left == null && getComparator().compare(data, toInsert) > 0)
			left = new BinarySearchNode(toInsert, treeComparator);
		if (right == null && getComparator().compare(data, toInsert) < 0)
			right = new BinarySearchNode(toInsert, treeComparator);

		if (left != null && getComparator().compare(data, toInsert) > 0)
			left.insert(toInsert);
		if (right != null && getComparator().compare(data, toInsert) < 0)
			right.insert(toInsert);
	}

	public boolean contains(Object element) {
		if (left != null && getComparator().compare(data, element) > 0)
			return left.contains(element);
		if (right != null && getComparator().compare(data, element) < 0)
			return right.contains(element);
		if (getComparator().compare(data, element) == 0)
			return true;
		return false;
	}

	public BinaryNode remove(Object toRemove) {
		if (left != null && getComparator().compare(toRemove, data) < 0)
			return ((BinarySearchNode) left).remove(toRemove);
		else if (right != null && getComparator().compare(toRemove, data) > 0)
			return ((BinarySearchNode) right).remove(toRemove);
		else {
			if (left == null && right == null)
				return null;
			else if (left != null && right == null)
				return left;
			else if (left == null && right != null)
				return right;
			else {
				data = ((BinarySearchNode) right).findMin();
				right = ((BinarySearchNode) right).remove(data);
			}
		}
		return this;
	}
}
