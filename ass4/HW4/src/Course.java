
public class Course {
	private String name;
	private int number;
	private int credit;

	// constructor-----> string.mathces:famous trick i had learned in high
	// school&its in stack over flow web site!
	public Course(String name, int number, int credit) {
		if (name == null || name.length() == 0 || number <= 0 || credit <= 0 || !(IsLegalString(name))) {
			throw new IllegalArgumentException("illegal argumints");
		}
		this.name = name;
		this.number = number;
		this.credit = credit;
	}

	// returns course's name
	public String getCourseName() {
		return this.name;
	}

	// returns course's number
	public int getCourseNumber() {
		return this.number;
	}

	// returns course's credit
	public int getCourseCredit() {
		return this.credit;
	}

	// returns a string representation
	public String toString() {
		return "CourseName:" + name + ", " + "CourseNumber:" + number + ", " + "CourseCredit:" + credit;
	}

	public boolean equals(Object other) {
		if (other == null)
			throw new IllegalArgumentException("other is null!");
		if (!(other instanceof Course))
			throw new IllegalArgumentException("other is not instanceof Course!");
		Course OtherCourse = (Course) other;
		// according to the give constructors we must only test according to number!?
		// thats mean we should delete this Other.name != name
		// ||!(other.toString().equals(this.toString())
		return OtherCourse.number == number;
	}

	// returns final grade
	public int computeFinalGrade(int grade) {
		throw new UnsupportedOperationException();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Helping function!
	private static boolean IsLegalString(String str) {
		int NameLen = str.length();
		if (NameLen == 0)
			return false;
		for (int i = 0; i < NameLen; i++) {
			if ((Character.isLetter(str.charAt(i)) == false) && (str.charAt(i) != ' ')
					&& Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/*public static void main(String[] args) {
		Course me = new Course("moham mad", 1, 1);
		Comparator averageComp = new StudentGradeAverageComparator();
		Course c = new Course("CsIntro", 1, 5);
		Student s1 = new Student("Yossi", "Cohen", 1);
		Student s2 = new Student("Avi", "Cohen", 2);
		s1.registerTo(c);
		s2.registerTo(c);
		s1.addGrade(c, 100);
		s2.addGrade(c, 95);
		System.out.println(averageComp.compare(s1, s2) > 0); // false
		System.out.println(averageComp.compare(s2, s1) < 0); // true

	}*/

}
