public class Bit {
	/*
	 * I created function called "ShowInt" that present the Integer value of the
	 * Bit!
	 */
	private int ShowInt() {
		if (value)
			return 1;
		else
			return 0;
	}

	private boolean value;

	public Bit(boolean value) {
		if (!value)
			this.value = false;
		else
			this.value = true;
	}

	public String toString() {
		if (!value)
			return "0";
		else
			return "1";
	}

	public boolean isOne() {
		if (!value)
			return false;
		else
			return true;
	}

	public boolean lessThan(Bit digit) {
		if (!value & digit.isOne())
			return true;
		else
			return false;

	}

	public boolean lessEq(Bit digit) {
		if (value & !digit.isOne())
			return false;
		else
			return true;
	}
	
	public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) {
		int ans = A.ShowInt() + B.ShowInt() + Cin.ShowInt();
		if (ans % 2 == 0)
			return new Bit(false);
		else
			return new Bit(true);
	}
    /*According to fullAdderCarry we get one if we have at least two 1s! */
	public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) {
		int ans = A.ShowInt() + B.ShowInt() + Cin.ShowInt();
		if (ans >= 2)
			return new Bit(true);
		else
			return new Bit(false);
	}

	public static void main(String[] args) {
		
	}
}