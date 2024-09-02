public class Phonebook {

	private BinarySearchTree namesTree;
	private BinarySearchTree numbersTree;

	public Phonebook() {
		namesTree = new BinarySearchTree(new EntryComparatorByName());
		numbersTree = new BinarySearchTree(new EntryComparatorByNumber());
	}

	public PhoneEntry lookUp(String name) {
		// create an Entry with the given name and a "dummy" number (1)
		// This "dummy" number will be ignored when executing getData
		PhoneEntry lookFor = new PhoneEntry(name, 1);
		return (PhoneEntry) namesTree.findData(lookFor);
	}

	public PhoneEntry lookUp(int number) {
		// create an Entry with a "dummy" name and the given number
		// This "dummy" name will be ignored when executing getData
		PhoneEntry lookFor = new PhoneEntry("dummy", number);
		return (PhoneEntry) numbersTree.findData(lookFor);
	}

	public void balance() {
		namesTree = new BinarySearchTree(namesTree);
		numbersTree = new BinarySearchTree(numbersTree);
	}

	public boolean add(PhoneEntry newEntry) {
		if (newEntry == null)
			throw new IllegalArgumentException("null");
		if (lookUp(newEntry.getName()) != null && lookUp(newEntry.getNumber()) != null)
			return false;
		namesTree.insert(newEntry);
		numbersTree.insert(newEntry);
		return true;
	}

	public boolean delete(String name) {
		if (name == null)
			throw new IllegalArgumentException("null");
		PhoneEntry p = lookUp(name);
		if (!namesTree.contains(p) || !numbersTree.contains(p))
			return false;
		this.namesTree.remove(p.getName());
		this.numbersTree.remove(p.getNumber());
		return true;
	}

	public boolean delete(int number) {
		PhoneEntry p = lookUp(number);
		if (!namesTree.contains(p) || !numbersTree.contains(p))
			return false;
		this.namesTree.remove(p.getName());
		this.numbersTree.remove(p.getNumber());
		return true;
	}

}
