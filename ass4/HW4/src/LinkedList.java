
import java.util.Iterator;

public class LinkedList implements List {
//
	private Link first;
	private Link last;

	// constructor
	public LinkedList() {
		first = null;
		last = null;
	}

	// adds a given object to the list*
	public void add(Object element) {
		nullCheck(element);
		if (isEmpty()) {
			// they are pointing to each other !
			first = new Link(element);
			last = first;
		} else {
			Link newLast = new Link(element);
			last.setNext(newLast);
			last = newLast;
		}
	}

	// adds a given object to a specific index*
	public void add(int index, Object element) {
		nullCheck(element);
		rangeCheck(index);
		if (index == 0) {
			first = new Link(element, first);
			if (last == null)
				last = first;
		} else {
			Link prev = null;
			Link curr = first;
			for (int i = 0; i < index; i = i + 1) {
				prev = curr;
				curr = curr.getNext();
			}
			Link toAdd = new Link(element, curr);
			prev.setNext(toAdd);
			if (index == size())
				last = toAdd;
		}
	}

	// returns if the list is empty
	public boolean isEmpty() {
		return first == null && last == null;
	}

	// returns element's data in a specific index
	public Object get(int index) {
		rangeCheck(index);
		LinkedListIterator iter = new LinkedListIterator(first);
		while (iter.hasNext() & index != 0) {
			iter.next();
			index -= 1;
		}
		return iter.next();
	}

	// returns the size of the list
	public int size() {
		int size = 0;
		LinkedListIterator iter = new LinkedListIterator(first);
		while (iter.hasNext()) {
			iter.next();
			size += 1;
		}
		return size;
	}

	// returns if a specific element is contained in the list
	public boolean contains(Object element) {
		nullCheck(element);
		LinkedListIterator iter = new LinkedListIterator(first);
		while (iter.hasNext()) {
			if (iter.next().equals(element))
				return true;
		}
		return false;
	}

	// sets a given element in a specific index
	// in this function i did not use Itarator!
	public Object set(int index, Object element) {
		nullCheck(element);
		rangeCheck(index);
		Link curr = first;
		while (index > 0) {
			index -= 1;
			curr = curr.getNext();
		}
		Object currData = curr.getData();
		curr.setData(element);
		return currData;
	}

	// returns a string representation
	public String toString() {
		String outpout = "<";
		LinkedListIterator iter = new LinkedListIterator(first);
		while (iter.hasNext()) {
			outpout = outpout + iter.next() + ",";
		}
		// Delete the last char in the string!(,)
		outpout = outpout.substring(0, outpout.length() - 1);
		return outpout + ">";
	}

	// returns if other equals to this
	public boolean equals(Object other) {
		nullCheck(other);
		if (!(other instanceof LinkedList)) {
			throw new NullPointerException("The given Object is Not LinkedList!");
		}
		if (((LinkedList) other).size() != size()) {
			return false;
		} // i could use iteration but i i like to test by string's equal!
		LinkedList otherLString = (LinkedList) other;
		String OtherString = otherLString.toString();
		if (!(OtherString.equals(toString())))
			return false;
		return true;
	}

	// sorts the list by Comparator
	public void sortBy(Comparator comp) {
		nullCheck(comp);
		if (isEmpty())// List is empty,no sorting needed
			return;
		// Perform a modified insertion sort
		int i = 0;
		LinkedListIterator iter1 = new LinkedListIterator(first);
		while (iter1.hasNext()) {
			Link prev = (Link) iter1.next();
			Link curr = (Link) iter1.next();
			LinkedListIterator iter2 = new LinkedListIterator(curr);
			while (iter2.hasNext()) {
				if (comp.compare(prev.getData(), curr.getData()) > 0) {
					set(i, prev);
				} else
					set(i, curr);
			}
			i = i + 1;
		}

	}

	// returns an iterator
	public Iterator iterator() {
		return new LinkedListIterator(first);
	}

	// throws an exception if the given index is not in range
	private void rangeCheck(int index) {
		if (index < 0 | index >= size())
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	}

	// throws an exception if the given element is null
	private void nullCheck(Object element) {
		if (element == null)
			throw new NullPointerException();
	}
	
	public boolean remove(Object toRemove) {
		if (toRemove == null)
			throw new IllegalArgumentException("input argument is null");
		Link current = first;
		Link prev = current;
		boolean removed = false;
		while (current != null & !removed) {
			if ((current.getData()).equals(toRemove)) {
				// if the first link should be removed
				if (current == first) {
					first = first.getNext();
				}
				else {
					prev.setNext(current.getNext());					
				}
				removed = true;
			}
			else {
				prev = current;
				current = current.getNext();
			}
		}
		return removed;
	}

	/*
	 * public static void main(String[] args) { LinkedList k1=new LinkedList();
	 * LinkedList k2=new LinkedList(); k1.add(1); k2.add(1);
	 * System.out.println(k1.equals(k2));
	 * 
	 * 
	 * }
	 */

}
