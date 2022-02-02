
public class Recursividad {

	public static void main(String[] args) {

		System.out.println(suma(5, 9));
		System.out.println(factorial(64));
		System.out.println(factorial2(19));
		System.out.println(toBinary(11));
		System.out.println(toBinary2(11));
		System.out.println(reverseWord("Hola"));
		System.out.println(reverseWord2("Hola"));

	}

	static int suma(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return 1 + suma(a, b - 1);
		}
	}

	static double factorial(double a) {
		if (a == 1) {
			return a;
		} else {
			return a * factorial(a - 1);
		}
	}

	static int factorial2(int a) {
		int aux = 1;

		for (int i = 2; i <= a; i++) {
			aux *= i;
		}
		return aux;
	}

	static String toBinary(int a) {
		if (a == 1) {
			return "1";
		} else {
			return toBinary(a / 2) + String.valueOf(a % 2);
		}

	}

	static String toBinary2(int a) {
		String aux = "";

		while (a / 2 >= 1) {
			aux += String.valueOf(a % 2);
			a = a / 2;
		}
		aux += "1";
		return aux;
	}

	static String reverseWord(String word) {
		if (word.isEmpty()) {
			return word;
		} else {
			return reverseWord(word.substring(1)) + word.charAt(0);
		}
	}

	static String reverseWord2(String word) {
		char ch;
		String nstr = "";
		
		for (int i = 0; i < word.length(); i++) {
			ch = word.charAt(i);
			nstr = ch + nstr;
		}
		return nstr;
	}

}
