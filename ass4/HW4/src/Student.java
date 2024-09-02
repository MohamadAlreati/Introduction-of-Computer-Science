import java.util.Iterator;

public class Student {
	private LinkedList MyCourses;// The Courses that the Student have!(UNLIMITED)!
	private LinkedList MyGrades;
	private String firstName;
	private String lastName;
	private int id;

	// constructor
	public Student(String firstName, String lastName, int id) {
		if (firstName == null || lastName == null || !(IsLegal(firstName)) || !(IsLegal(lastName)) || id <= 0)
			throw new IllegalArgumentException();
		this.MyCourses = new LinkedList();
		this.MyGrades = new LinkedList();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public LinkedList GetMyCourses() {
		return this.MyCourses;

	}

	public LinkedList GetMyGrades() {
		return this.MyGrades;

	}

	// returns first name
	public String getFirstName() {
		return this.firstName;
	}

	// returns last name
	public String getLastName() {
		return this.lastName;
	}

	// returns id
	public int getId() {
		return this.id;
	}

	// returns if this is registered to course
	public boolean isRegisteredTo(Course course) {
		return MyCourses.contains(course);
	}

	// registers this to course
	public boolean registerTo(Course course) {
		if (isRegisteredTo(course))
			return false;
		MyCourses.add(course);
		return true;
	}

	// returns the average
	public double calculateAverage() {
		if (MyGrades.isEmpty()) {
			return 0.0;// the student did not have any Grade!
		}
		int sum1 = 0;
		int sum2 = 0;
		Iterator<Grade> iter1 = MyGrades.iterator();
		while (iter1.hasNext()) {
			Grade g = (Grade) iter1.next();
			int CurrGrade = g.getGrade();
			int CurrCridit = (g.getCourse()).getCourseCredit();
			sum1 = sum1 + (CurrGrade * CurrCridit);
			sum2 = sum2 + CurrCridit;
		}
		return (double)sum1/sum2;
	}

	// adds grade to student
	public boolean addGrade(Course course, int grade) {
		Iterator<Grade> it1 = MyGrades.iterator();
		while (it1.hasNext()) {
			Grade g = (Grade) it1.next();
			if (g.getCourse().equals(course))// already have one!
				return false;
		}
		Iterator<Course> it2 = MyCourses.iterator();
		while (it2.hasNext()) {
			Course c = (Course) it2.next();
			if (c.equals(course)) {
				MyGrades.add(new Grade(c, grade));
				return true;
			}
		}
		return false;

	}

	// sets a grade
	public int setGrade(Course course, int grade) {
		if(MyGrades.isEmpty()) {
			throw new IllegalArgumentException("The student did not have a grade in this Course!");
		}
		Iterator<Grade> iter1 = MyGrades.iterator();
		while (iter1.hasNext()) {
			Grade g = (Grade) iter1.next();
			if (g.getCourse().equals(course)) {
				int prev = g.getGrade();
				g.setGrade(grade);
				return prev;
			}
		}
		throw new IllegalArgumentException("The student did not have a grade in this course!");

	}

	// returns a string representation
	public String toString() {
		return firstName + " " + lastName + ":" + id;
	}

	// returns if other equals to this
	public boolean equals(Object other) {
		if (other == null)
			throw new IllegalArgumentException("null input!");
		if (!(other instanceof Student))
			return false;
		return getId() == ((Student) other).getId();

	}

	// returns total credit required
	public int getTotalCreditRequired() {
		throw new UnsupportedOperationException();
	}

	// returns final grade
	public double computeFinalGrade() {
		throw new UnsupportedOperationException();
	}

	// helping function!
	private boolean IsLegal(String str) {
		int NameLen = str.length();
		if (NameLen == 0)
			return false;
		for (int i = 0; i < NameLen; i++) {
			if ((Character.isLetter(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
				return false;
			}
		}
		return true;

	}

	/*
	 * public static void main(String[] args) { Comparator averageComp = new
	 * StudentGradeAverageComparator(); Course c = new Course("CsIntro", 1, 5);
	 * Student s1 = new Student("Yossi", "Cohen", 1); Student s2 = new
	 * Student("Avi", "Cohen", 2); s1.registerTo(c); s2.registerTo(c);
	 * s1.addGrade(c, 100); s2.addGrade(c, 95);
	 * System.out.println(s1.calculateAverage());
	 * System.out.println(s2.calculateAverage()); Comparator nameComp = new
	 * StudentNameComparator(); System.out.println(nameComp.compare(s1, s2) > 0); //
	 * true System.out.println(nameComp.compare(s2, s1) > 0); // false } Student
	 * mohammad = new Student("mohammad", "ibraheem", 312412); Course logica = new
	 * Course("mathmatic", 11, 5); Grade log = new Grade(logica, 90);
	 * mohammad.MyCourses.add(logica); mohammad.MyGrades.add(log); Course computer =
	 * new Course("computer", 22, 3); Grade comp = new Grade(computer, 100);
	 * mohammad.MyCourses.add(computer); mohammad.MyGrades.add(comp); Course
	 * Alogorthim = new Course("Alogorthim", 33, 5); Grade Algo = new
	 * Grade(Alogorthim, 80); mohammad.MyCourses.add(Alogorthim);
	 * mohammad.MyGrades.add(Algo); System.out.println(mohammad.calculateAverage());
	 * }
	 */

	/*public static void main(String[] args) {
		Student s1 = new Student("mohammad", "Ibraheem", 2182613);
		Course c1=new Course("Math", 10, 5);
		Course c2=new Course("Arabic", 11, 3);
		Course c3=new Course("Hebrow", 12, 1);
		
		s1.MyGrades.add(new Grade(c1, 100));
		s1.MyGrades.add(new Grade(c2, 90));
		s1.MyGrades.add(new Grade(c3, 80));
		
		System.out.println(s1.MyGrades.toString());
		System.out.println(s1.calculateAverage());
		
		System.out.println(s1.setGrade(c2, 90));
		
		System.out.println(s1.MyGrades.toString());
		System.out.println(s1.calculateAverage());
		
	}*/
	

}
