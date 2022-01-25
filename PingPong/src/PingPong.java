import java.util.Scanner;

public class PingPong {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[] points = new int[2];

		int partidas = in.nextInt();
		while (partidas != 0) {
			for (int i = 0; i < partidas; i++) {
				casoDePrueba(points);
			}
			partidas = in.nextInt();
		}
		System.out.println(points[0] + " " + points[1]);
	}

	static void casoDePrueba(int[] points) {
		int direction = 0;
		String data = "";
		data = in.next();
		if (data.equalsIgnoreCase("PIC")) {
			if (direction == 0) {
				direction = 1;
			} else {
				direction = 0;
			}
		}
		if (data.equalsIgnoreCase("PONG!")) {
			points[direction] += 1;
		}
	}

}
