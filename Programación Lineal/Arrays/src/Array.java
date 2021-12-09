import java.util.ArrayList;

public class Array {

	public static void main(String[] args) throws InterruptedException {
		String[][] shit = { { "Audi", "BMW", "Aston Martin", "Ferrari", "Lambo" },
				{ "Suka", "Blyat", "Rush", "Aaaaa", "Blya" } };
		String[] cars = { "Audi", "BMW", "Aston Martin", "Ferrari", "Lambo" };
		ArrayList<String> numbers = new ArrayList<String>();
		int[] primary = new int[3];
		int[] secondary = { 1, 2, 3 };

		for (int u = 0; u < shit.length; ++u) {
			for (int j = 0; j < shit[u].length; ++j) {
				Thread.sleep(100);
				System.out.println(shit[u][j]);
			}
		}

		for (String i : cars) {
			Thread.sleep(100);
			System.out.println(i);
		}

		numbers.add("One");
		numbers.add("Two");
		numbers.add("Three");

		numbers.forEach((n) -> {
			try {
				Thread.sleep(300);
				System.out.println(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		primary[0] = 1;
		primary[1] = 2;
		primary[2] = 3;

		for (int i : primary) {
			System.out.println(i);
		}

		
		for (int j : secondary) {
			System.out.println(j);
		}

	}

}
