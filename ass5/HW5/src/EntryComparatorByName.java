import java.util.Comparator;

public class EntryComparatorByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof PhoneEntry && o2 instanceof PhoneEntry)
			return ((PhoneEntry) o1).getName().compareTo(((PhoneEntry) o2).getName());
		throw new IllegalArgumentException();
	}

}
