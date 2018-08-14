package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Pair1 {
	int x, y;

	Pair1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair1 other = (Pair1) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class QueenAttack {

	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		// Complete this function
		Set<Pair1> obs = new HashSet<>();
		int i, j;
		for (i = 0; i < k; i++) {
			obs.add(new Pair1(obstacles[i][0], obstacles[i][1]));
		}

		int result = 0;
		// case 1 left
		i = r_q;
		for (j = c_q - 1; j >= 0; j--) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 1" + result);
		// case 2 right
		i = r_q;
		for (j = c_q + 1; j < n; j++) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 2" + result);
		// case 3 up
		j = c_q;
		for (i = r_q - 1; i >= 0; i--) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 3" + result);
		// case 4 down
		j = c_q;
		for (i = r_q + 1; i < n; i++) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 4" + result);
		// case 5 toward left top
		for (i = r_q - 1, j = c_q - 1; i >= 0 && j >= 0; i--, j--) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 5" + result);
		// case 6 toward right top
		for (i = r_q - 1, j = c_q + 1; i >= 0 && j < n; i--, j++) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 6" + result);
		// case 7 toward left bottom
		for (i = r_q + 1, j = c_q - 1; i < n && j >= 0; i++, j--) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 7" + result);
		// case 8 toward right bottom
		for (i = r_q + 1, j = c_q + 1; i < n && j < n; i++, j++) {
			if (obs.contains(new Pair1(i, j))) {
				break;
			}
			result++;
		}
		//System.out.println("case 8" + result);
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int r_q = in.nextInt() - 1;
		int c_q = in.nextInt() - 1;
		int[][] obstacles = new int[k][2];
		for (int obstacles_i = 0; obstacles_i < k; obstacles_i++) {
			for (int obstacles_j = 0; obstacles_j < 2; obstacles_j++) {
				obstacles[obstacles_i][obstacles_j] = in.nextInt() - 1;
			}
		}
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.println(result);
		in.close();
	}
}
