public class BinaryTree {
	
	protected BinaryNode root;

	public BinaryTree(){
		root = null;
	}

	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(Object element) {
		if(isEmpty()) 
			root = new BinaryNode(element);
		else 
			root.insert(element);
	}
	
	public boolean contains(Object element) {
		if(isEmpty())
			return false;
		else 
			return root.contains(element);
	}
	
	public int height(){
		if(isEmpty())
			return -1;
		else 
			return root.height();
	}
	
	public int size(){
		if(isEmpty())
			return 0;
		else 
			return root.size();
	}
	
	public void inOrder() {
		if(!isEmpty())
			root.inOrder();
	}
	
	public void preOrder() {
		if(!isEmpty())
			root.preOrder();
	}
	
	public void postOrder() {
		if(!isEmpty())
			root.postOrder();
	}	
	
	public boolean equals(Object other){
		if(!(other instanceof BinaryTree)) 
			return false;
		BinaryTree otherTree = (BinaryTree)other;
		if(size() != otherTree.size())
			return false;
		if(size() != 0) //empty trees
			return root.equals(otherTree.root);
		return true;
	}

	public String toString(){
		if(!isEmpty())
			return root.toString();
		else
			return "Empty Tree";
	}
}

