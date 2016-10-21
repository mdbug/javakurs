package blatt02;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaCode {
	private ArrayList<String> code = new ArrayList<>();
	
	public void ladeCode(Scanner sc) {
		while(sc.hasNextLine()) {
			code.add(sc.nextLine());
		}
	}
	
	public void schreibeCode(PrintWriter pw) {
		for (String s : code) {
			pw.println(s);
		}
	}
	
	public void entferneKommentare() {
		boolean block = false;
		for(int i=0; i < code.size(); i++) {
			String line = code.get(i);
			
			if (block) {
				if (line.indexOf("*/") != -1) {
					block = false;
				}
				code.remove(i);
				i--;
				continue;
			}
			if (line.indexOf("/*") != -1) {
				block = true;
				code.remove(i);
				i--;
				continue;
			}
			
			switch(line.indexOf("//")) {
			case -1:
				break;
			case 0:
				code.remove(i);
				i--;
				break;
			default:
				line = line.replaceAll("//.*$", "");
				code.set(i, line);
				break;
			}
		}
	}
	
}
