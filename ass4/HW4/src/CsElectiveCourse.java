
public class CsElectiveCourse extends Course { // you need to add inheritance

	// constructor
	public CsElectiveCourse(String name, int number, int credit) {
		super(name, number, credit);
	}

	// returns final grade
	public int computeFinalGrade(int grade) {
		throw new UnsupportedOperationException();
	}

}
