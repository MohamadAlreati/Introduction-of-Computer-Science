public class BinaryNode {

	protected Object data;
	protected BinaryNode left;
	protected BinaryNode right;

	public BinaryNode(Object element) {
		if (element == null)
			throw new NullPointerException();
		this.data = element;
		left = null;
		right = null;
	}

	public void insert(Object element) {
		if (Math.random() < 0.5) {
			if (left == null)
				left = new BinaryNode(element);
			else
				left.insert(element);
		} else {
			if (right == null)
				right = new BinaryNode(element);
			else
				right.insert(element);
		}
	}

	public boolean contains(Object element) {
		boolean found = false;
		if (data.equals(element))
			found = true;
		else if (left != null && left.contains(element))
			found = true;
		else if (right != null && right.contains(element))
			found = true;
		return found;
	}

	public int height() {
		int leftH = 0, rightH = 0;
		if (left != null)
			leftH = left.height();
		if (right != null)
			rightH = right.height();
		return Math.max(leftH, rightH) + 1;
	}

	public int size() {
		int leftS = 0, rightS = 0;
		if (left != null)
			leftS = left.size();
		if (right != null)
			rightS = right.size();
		return leftS + rightS + 1;
	}

	public void inOrder() {
		if (left != null)
			left.inOrder();
		System.out.println(data.toString());
		if (right != null)
			right.inOrder();
	}

	public void preOrder() {
		System.out.println(data.toString());
		if (left != null)
			left.preOrder();
		if (right != null)
			right.preOrder();
	}

	public void postOrder() {
		System.out.println(data.toString());
		if (left != null)
			left.postOrder();
		if (right != null)
			right.postOrder();
	}

	public boolean equals(Object other) {
		if (!(other instanceof BinaryNode))
			return false;
		return equals(this, (BinaryNode) other);
	}

	private static boolean equals(BinaryNode firstRoot, BinaryNode secondRoot) {
		boolean areEqual = (firstRoot == secondRoot);
		if (!areEqual) {
			if (firstRoot != null & secondRoot != null)
				areEqual = firstRoot.data.equals(secondRoot.data) && equals(firstRoot.left, secondRoot.left)
						&& equals(firstRoot.right, secondRoot.right);
		}
		return areEqual;
	}

	public String toString() {
		String s=StringHelper(0);
		return s;
	}
	//auxiliary function
	public String StringHelper(int index)
	{
		String s="";
		if(left!=null)
			s=s+ left.StringHelper(index+1);
		s=s+Spaces(index);
		s=s+data+"\n";
		if(right!=null)
			s=s+right.StringHelper(index+1);
		return s;
	}
	private String Spaces(int index) {
		String s = "";
		for (int i = 0; i < index; i++) {
			s = s + "  ";
		}
		return s;
	}
}