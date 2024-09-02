
public class StudentGradeAverageComparator implements Comparator {

	// compares between obj1 and obj2
	public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof Student)||!(obj2 instanceof Student)) {
			throw new IllegalArgumentException("wrong inputs");
		}
		Double s1=((Student)obj1).calculateAverage();
		Double s2=((Student)obj2).calculateAverage();
		return s2.compareTo(s1);//be cearful here !
	}
/*public static void main(String[] args) {
	Comparator averageComp= new StudentGradeAverageComparator();
	Course c = new Course("CsIntro", 1, 5);
	Student s1 = new Student("Yossi", "Cohen", 1);
	Student s2 = new Student("Avi", "Cohen", 2);
	//
	System.out.println("did you add s1? "+ s1.registerTo(c));
	System.out.println("did you add s2? "+ s2.registerTo(c));
	
	System.out.println("did you add the grade for s1? "+ s1.addGrade(c, 100));
	System.out.println("did you add the grade for s1? "+ s2.addGrade(c, 95));
	System.out.println(s1.calculateAverage() ); 
	System.out.println(s2.calculateAverage() );
	System.out.println(averageComp.compare(s1, s2) > 0); // false 
	System.out.println(averageComp.compare(s2, s1) > 0); // true
}*/
	/*public static void main(String[] args) {
		Comparator nameComp = new StudentNameComparator(); 
		Student s1 = new Student("Yossi", "Cohen", 1);
		Student s2 = new Student("Avi", "Cohen", 2); 
		System.out.println(nameComp.compare(s1, s2) > 0); // true 
		System.out.println(nameComp.compare(s2, s1) > 0); // false
	}*/
	/*public static void main(String[] args) {
		Comparator averageComp= new StudentGradeAverageComparator();
		Course c = new Course("CsIntro", 1, 5);
		Student s1 = new Student("Yossi", "Cohen", 1);
		Student s2 = new Student("Avi", "Cohen", 2);
		s1.registerTo(c);
		s2.registerTo(c);
		s1.addGrade(c, 100);
		s2.addGrade(c, 95);
		System.out.println(s1.calculateAverage());
		System.out.println(s2.calculateAverage());
		System.out.println(averageComp.compare(s1, s2) > 0); // false 
		System.out.println(averageComp.compare(s2, s1) > 0); //true

	}*/
}
