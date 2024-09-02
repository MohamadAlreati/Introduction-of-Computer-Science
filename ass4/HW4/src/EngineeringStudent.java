
public class EngineeringStudent extends Student { // you need to add inheritance

	// constructor
	public EngineeringStudent(String firstName, String lastName, int id) {
		super(firstName,lastName,id);
	}
	
	// returns total credit required
	public int getTotalCreditRequired(){
		throw new UnsupportedOperationException();
	}

}
