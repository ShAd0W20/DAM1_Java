import java.util.ArrayList;

public class Array {

	public static void main(String[] args) throws InterruptedException {
		String[][] shit = { { "Audi", "BMW", "Aston Martin", "Ferrari", "Lambo" }, { "Suka", "Blyat", "Rush", "Aaaaa" } };
		String[] cars = { "Audi", "BMW", "Aston Martin", "Ferrari", "Lambo" };
		ArrayList<String> numbers = new ArrayList<String>();
		
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

	}

}
