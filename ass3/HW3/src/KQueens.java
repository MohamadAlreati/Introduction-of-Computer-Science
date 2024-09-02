/*I added some helping function dawn below! */

public class KQueens {
	final static int QUEEN = 1;
	final static int WALL = -1;
	final static int EMPTY = 0;

	/*---------------------------------------------------------------------------------------------------------------------------------*/
	//Note:i added simple functions to make the code less complicated! 
	/* check if the given element is in the given array! */
	public static boolean Check(int[] a, int num) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == num)
				return true;
		}
		return false;
	}
	/* check if the the Queen is Threatened by the column! */
	public static boolean IsQueenThreatenedByCol(int[][] Board, int row, int col) {
		boolean Threatened = true;
		for (int i = row + 1; i < Board.length && Threatened; i++) {
			if (Board[i][col] == WALL) {
				Threatened = false;

			} else if (Board[i][col] == QUEEN) {
				return true;

			}
		}
		Threatened = true;
		for (int i = row - 1; i >= 0 && Threatened; i--) {
			if (Board[i][col] == WALL) {
				Threatened = false;

			} else if (Board[i][col] == QUEEN) {
				return true;

			}
		}
		return false;
	}
	/* check if the the Queen is Threatened by the row! */
	public static boolean IsQueenThreatenedByRow(int[][] Board, int row, int col) {
		boolean Threatened = true;
		for (int j = col + 1; j < Board[0].length && Threatened; j++) {
			if (Board[row][j] == WALL) {
				Threatened = false;
			} else if (Board[row][j] == QUEEN) {
				return true;
			}
		}
		Threatened = true;
		for (int j = col - 1; j >= 0&&Threatened; j--) {
			if (Board[row][j] == WALL) {
				Threatened = false;
			} else if (Board[row][j] == QUEEN) {
				return true;
			}
		}
		return false;
	}
	/* check if the the Queen is Threatened by positive diameter(positive mile)! */
	public static boolean isQueenThreatenedByDiameter2(int[][] Board, int row, int col) {
		boolean Threatened = true;
		for (int i = row - 1, j = col + 1; i >= 0 && j < Board.length && Threatened; i--, j++) {
			if (Board[i][j] == WALL) {
				Threatened = false;
			}
			if (Board[i][j] == QUEEN) {
				return true;
			}
		}

		for (int i = row + 1, j = col - 1; i < Board.length && j >= 0 && Threatened; i++, j--) {
			if (Board[i][j] == WALL) {
				Threatened = false;
			}
			if (Board[i][j] == QUEEN) {
				return true;
			}
		}
		return false;
	}
	/*check if the the Queen is Threatened by positive diameter(positive mile)!*/
	public static boolean isQueenThreatenedByDiameter1(int[][] Board, int row, int col) {
		boolean Threatened = true;
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 & Threatened; i--, j--) {
			if (Board[i][j] == WALL) {
				Threatened = false;
			}
			if (Board[i][j] == QUEEN) {
				return true;
			}
		}
		Threatened = true;
		for (int i = row + 1, j = col + 1; i < Board.length && j < Board.length && Threatened; i++, j++) {
			if (Board[i][j] == WALL) {
				Threatened = false;
			}
			if (Board[i][j] == QUEEN) {
				return true;
			}
		}
		return false;
	}

/*--------------------------------------------------------------------------------------------------------------------------------*/
	/*
	 * Task1.1
	 */
	public static boolean isValidInput(int k, int rows, int cols, int[][] walls) {
		if (rows < 1 | cols < 1 | k < 1 | walls == null | walls.length != rows)
			return false;
		int SumOfWalls = 0;
		for (int i = 0; i < walls.length; i++) {
			if (walls[i] == null)
				return false;
			for (int j = 0; j < walls[i].length; j++) {
				int Wall= walls[i][j];
				// the numbers in walls present digit(should be positive & legal one)
				if (Wall < 0 | (Wall > cols & Wall > rows)) {
					return false;
				}
				SumOfWalls += 1;
			}
		}
		if (((rows * cols) - SumOfWalls < k))
			return false;
		return true;
	}

	/*
	 * Task1.2
	 */
	public static int[][] createBoard(int rows, int cols, int[][] walls) {
		/* java will assign the default value 0 to each element of the array!*/
		int Board[][] = new int[rows][cols];
		for (int i = 0; i < walls.length; i++) {
			for (int j = 0; j < walls[i].length; j++) {
				Board[i][walls[i][j]] = WALL;
			}
		}
		return Board;
	}

	/*
	 * Task1.3
	 */
	public static void printBoard(int[][] board) {
		if (board.length == 0)
			System.out.println("There is no solution");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == QUEEN)
					System.out.print("Q");
				else if (board[i][j] == WALL)
					System.out.print("X");
				else
					System.out.print("*");
				/*prevent adding space at the end of each row*/
				if (j != board[i].length - 1) {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

	/*
	 * Task1.4.A
	 */
	public static boolean validateWalls(int[][] walls, int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == WALL) {
					if (!Check(walls[i], j)) {
						return false;
					}
				}
			}
		}
		for (int x = 0; x < walls.length; x++) {
			for (int y = 0; y < walls[x].length; y++) {
				if (board[x][walls[x][y]] != WALL)
					return false;
			}
		}
		return true;
	}

	/*
	 * Task1.4.B//StackOverFlow solution!
	 */
	public static boolean isQueenThreatened(int[][] board, int row, int col) {
		return (IsQueenThreatenedByCol(board, row, col)|| IsQueenThreatenedByRow(board, row, col)
				|| isQueenThreatenedByDiameter1(board, row, col) || isQueenThreatenedByDiameter2(board, row, col));
	}

	/*
	 * Task1.4.C
	 */
	public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls) {
		/*honestly i dint know what to write here every thing is clear according to the variables names! */
		if (board.length != rows || board[0].length != cols) {
			return false;
		}
		int SumOfQueens = 0;
		if (!(validateWalls(walls, board)) | !(isValidInput(k, rows, cols, walls)))
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 1 && board[i][j] != 0 && board[i][j] != -1)
					return false;
				if (board[i][j] == QUEEN) {
					SumOfQueens += 1;
					if (isQueenThreatened(board, i, j))
						return false;
				}
			}
		}
		if (SumOfQueens != k)
			return false;

		return true;
	}

	/*
	 * Task1.5
	 */
	public static boolean addQueen(int[][] board, int row, int col) {
		/*In this fun if board[row][col] have already Queen its not adding ONE(returns false)*/
		if (board[row][col] != QUEEN) {
			if (!(isQueenThreatened(board, row, col))) {
				board[row][col] = QUEEN;
				return true;
			}
		}
		return false;
	}

	/*
	 * Task1.6.A
	 */
	public static int[][] kQueens(int k, int rows, int cols, int[][] walls) {
		if (!(isValidInput(k, rows, cols, walls))) {
			int Empty[][] = {};
			return Empty;
		}
		int board[][] = createBoard(rows, cols, walls);
		kQueens(board, k, 0, 0, 1);
		return board;
		/*
		 * i did nor understand the Q,where exactly to add the the Queen(first i import
		 * math random package to add at least random Queen at one possible index.and
		 * asking to send the board with witch col and row...
		 */
	}

	/*
	 * Task1.6.B
	 */
	private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens) {
		throw new UnsupportedOperationException();
	}
}