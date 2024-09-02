
public class Task4 {
	

	/*
	 * Task4.1
	 */ // put the literals in one clause!
	public static int[][] atLeastOne(int[] lits) {
		int[][] cnf = new int[1][lits.length];
		for (int i = 0; i < lits.length; i++) {
			cnf[0][i] = lits[i];
		}
		return cnf;
	}
	
	//*lits={-1,2,-3;
	//cnf= {{-1,2,-3}};

	/*
	 * Task4.2
	 */ // each literal should be with each other literal in one clause but in negative.
	public static int[][] atMostOne(int[] lits) {
		int[][] cnf = new int[lits.length * (lits.length - 1) / 2][2];//
		for (int i = 0; i < lits.length; i++) {
			for (int j = i + 1, x = 0; j < lits.length; j++, x++) {
				cnf[x][0] = -1 * lits[i];
				cnf[x][1] = -1 * lits[j];
			}
		}
		return cnf;
	}

	/*
	 * Task4.3
	 */ // in this fun I merge the two arrays above in one!
	public static int[][] exactlyOne(int[] lits) {
		int[][] atMost = atMostOne(lits);
		int[][] cnf = new int[atMost.length + 1][];
		for (int i = 0; i < atMost.length; i++) {
			cnf[i] = atMost[i];
		}
		cnf[atMost.length] = atLeastOne(lits)[0];// pointing to the single clause in atLeastOne.
		return cnf;
	}
	public static void main(String[] args) {
		int lits[]= {0,1,2,3};
		int cnf[][]=atLeastOne(lits);	
		
	}
}
