
public class Grade {
	private Course course;
	private int grade;

	// constructor
	public Grade(Course course, int grade) {
		if (course == null || grade < 0 || grade > 100)
			throw new IllegalArgumentException("wrong inputs!");
		this.course = course;
		this.grade = grade;
	}

	// returns the course
	public Course getCourse() {
		return this.course;
	}

	// returns course's grade
	public int getGrade() {
		return this.grade;
	}

	// sets course's grade
	public int setGrade(int NewGrade) {
		if (NewGrade < 0 || NewGrade > 100)
			throw new IllegalArgumentException("wrong Grade!");
		int oldgrade = getGrade();
		this.grade = NewGrade;
		return oldgrade;
	}

	// returns a string representation
	public String toString() {
		return course.toString() + "------>Grade:" + grade;
	}

	// returns if other equals to this
	public boolean equals(Object other) {
		if (other == null)
			throw new IllegalArgumentException("other is null!");
		if (!(other instanceof Grade))
			throw new IllegalArgumentException("other is not instanceof Course!");
		Grade newGrade = (Grade) other;
		if (newGrade.getGrade() != grade || newGrade.getCourse().equals(course))
			return false;
		return true;
	}

	// returns final grade
	public int computeFinalGrade() {
		throw new UnsupportedOperationException();
	}

}
