package recursion;

// https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
// https://www.youtube.com/watch?v=rf6uf3jNjbo
public class TowerOfHanoi {

	public void towerOfHanoi(int n, char source, char destination, char aux) {
		if (n == 0)
			return;

		towerOfHanoi(n - 1, source, aux, destination);
		System.out.println("Disk " + n + " moved " + source + " --> " + destination);
		towerOfHanoi(n - 1, aux, destination, source);
	}

	public static void main(String[] args) {
		TowerOfHanoi obj = new TowerOfHanoi();

		int n = 4;
		obj.towerOfHanoi(n, 'A', 'B', 'C');

	}

}
