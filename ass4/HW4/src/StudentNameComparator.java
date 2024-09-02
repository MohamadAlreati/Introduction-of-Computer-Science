
public class StudentNameComparator implements Comparator {
	
	// compares between obj1 and obj2 in terms of name
	public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof Student)||!(obj2 instanceof Student)) {
			throw new IllegalArgumentException("wrong inputs");
		}
		int i=((Student)obj1).getLastName().compareTo(((Student)obj2).getLastName());
		if(i==0) {
			return ((Student)obj1).getFirstName().compareTo(((Student)obj2).getFirstName());
		}
		else
			return i;
	}
	
	/*public static void main(String[] args) {
		Comparator nameComp = new StudentNameComparator(); 
		Student s1 = new Student("Yossi", "Cohen", 1);
		Student s2 = new Student("Avi", "Cohen", 2); 
		System.out.println(nameComp.compare(s1, s2) > 0); // true 
		System.out.println(nameComp.compare(s2, s1) > 0); // false
	}*/

}
