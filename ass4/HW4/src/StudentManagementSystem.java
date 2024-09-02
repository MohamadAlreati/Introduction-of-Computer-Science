import java.util.Iterator;

public class StudentManagementSystem {
	private LinkedList StudentsList;
	private LinkedList CoursesList;
	private int numOfStudents;
	private int numOfCourses;

	// constructor
	public StudentManagementSystem() {
		StudentsList = new LinkedList();
		CoursesList = new LinkedList();
		this.numOfStudents = 0;
		this.numOfCourses = 0;
	}

	// adds a student
	public boolean addStudent(Student student) {
		if (StudentsList.contains(student))
			return false;
		StudentsList.add(student);
		numOfStudents = numOfStudents + 1;
		return true;
	}

	// adds a course
	public boolean addCourse(Course course) {
		if (CoursesList.contains(course))
			return false;
		CoursesList.add(course);
		numOfCourses = numOfCourses + 1;
		return true;
	}

	// registers a student to a course
	public boolean register(Student student, Course course) {
		if (!CoursesList.contains(course) || !StudentsList.contains(student)) {
			return false;
		}
		Iterator<Student> it = StudentsList.iterator();
		// searching for the the student to add the course in the student courses List!
		while (it.hasNext()) {
			Student s = (Student) it.next();
			if (s.equals(student)) {
				s.GetMyCourses().add(course);
				return true;
			}
		}
		return false;

	}

	// returns first K students according to a given comparator
	public LinkedList getFirstKStudents(Comparator comp, int k) {
		if (comp == null || k > StudentsList.size() || k < 0)
			throw new IllegalArgumentException("wrong inputs");
		LinkedList Kstudents = new LinkedList();
		Iterator iter = StudentsList.iterator();
		// adding the first k student in the new LinkedList!
		while (iter.hasNext() && k > 0) {
			Student stu = (Student) iter.next();
			Kstudents.add(stu);
			k--;
		}
		return SortByComparator(comp, Kstudents, k);
	}

	public LinkedList SortByComparator(Comparator comp, LinkedList Kstudents, int k) {
		for (int i = 0; i < k - 1; i++) {
			for (int j = 0; j < k - i - 1; j++) {
				if (comp.compare(Kstudents.get(j), Kstudents.get(j + 1)) > 0) {
					// Swap elements at index j and j + 1
					Student temp = (Student) Kstudents.get(j);
					Kstudents.set(j, Kstudents.get(j + 1));
					Kstudents.set(j + 1, temp);
				}
			}
		}
		return Kstudents;
	}

	// adds a grade to a given student
	public boolean addGradeToStudent(Student student, Course course, int grade) {
		if (!register(student, course))
			return false;
		Iterator<Student> it = StudentsList.iterator();
		boolean added = false;
		while (it.hasNext() & !added) {
			Student s = (Student) it.next();
			if (s.equals(student)) {
				s.setGrade(course, grade);
				added = true;
			}
		}
		return added;

	}

	// returns number of students
	public int getNumberOfStudents() {
		return this.numOfStudents;
	}

	// returns number of courses
	public int getNumberOfCourses() {
		return this.numOfCourses;
	}

	// returns final grade of a given student
	public double computeFinalGrade(Student student) {
		throw new UnsupportedOperationException();
	}

}
