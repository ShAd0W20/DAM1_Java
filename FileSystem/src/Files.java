import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		File f = new File("Hello.txt");
		Scanner fileInput = null;
		
		ArrayList<String> fileData = new ArrayList<String>();

		try {
			fileInput = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (fileInput.hasNextLine()) {
			fileData.add(fileInput.nextLine());
		}

		PrintStream output = null;
		try {
			output = new PrintStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 5; i++) {
			fileData.add(userInput.nextLine());
		}

		for (String s : fileData) {
			output.println(s);
		}

		output.close();
		fileInput.close();
		userInput.close();
	}

}
