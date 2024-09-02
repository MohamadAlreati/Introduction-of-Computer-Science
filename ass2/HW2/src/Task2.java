import java.util.Iterator;

public class Task2 {

	/*
	 * Task2.1
	 */ // Searching for the k in FriendArray!
	public static boolean hasFriend(int[] friends, int k) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == k)
				return true;
		}
		return false;
	}

	/*
	 * Task2.2
	 */
	public static boolean isLegalFriendsList(int[][] friendsList) {
		if (friendsList == null)
			return false;
		for (int i = 0; i < friendsList.length; i++) {
		    if(friendsList[i] == null)
				return false;
			for (int j = 0; j < friendsList[i].length; j++) {
				// Testing if the element is in the given range(according to Array length)
				int v = friendsList[i][j];
				if ( v < 0 || friendsList.length <= v)
					return false;
				if (!(hasFriend(friendsList[v], i)) & friendsList[v].length != -1)
					return false;
			}
		}
		return true;
	}

	/*
	 * Task2.3
	 */
	public static boolean isLegalFriendsMatrix(boolean[][] friendsMatrix) {
		if(friendsMatrix==null)
			return false;
		for (int i = 0; i < friendsMatrix.length; i++) {
			if(friendsMatrix[i]==null)
				return false;
			for (int j = 0; j < friendsMatrix[i].length; j++) {
				if ((!friendsMatrix[i][j] & friendsMatrix[j][i]) | (!friendsMatrix[j][i] & friendsMatrix[i][j]))
					return false;
			}
		}
		return true;
	}

}
