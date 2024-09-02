
public class ElectiveCourse extends Course { // you need to add inheritance

	public ElectiveCourse(String name, int number, int credit) {
		super(name, number, credit);
	}

	// returns final grade
	public int computeFinalGrade(int grade) {
		throw new UnsupportedOperationException();
	}

}
