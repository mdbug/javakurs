package blatt02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class JavaCodeTest {

	public static void main(String[] args) {
		File file = null;
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} else {
			System.out.println("Auswahl abgebrochen");
		}
		
		try(Scanner sc = new Scanner(file); PrintWriter pw = new PrintWriter(file.getName() + ".out");) {
			JavaCode code = new JavaCode();
			code.ladeCode(sc);
			code.entferneKommentare();
			code.schreibeCode(pw);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
