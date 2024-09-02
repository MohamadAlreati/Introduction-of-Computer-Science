import java.util.Comparator;

public class EntryComparatorByNumber implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof PhoneEntry&&o2 instanceof PhoneEntry))
			throw new IllegalArgumentException();
		return ((PhoneEntry)o1).getNumber().compareTo(((PhoneEntry)o2).getNumber());
	}

}
