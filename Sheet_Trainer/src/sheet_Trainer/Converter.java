package sheet_Trainer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.jfugue.*;

public class Converter {
	public static String ConvertToString(Pattern input) {
		 
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 PrintStream ps = new PrintStream(baos);
		 PrintStream old = System.out;
		 System.setOut(ps);
		 System.out.println(input);
		 System.out.flush();
		 System.setOut(old);
		 String String = baos.toString();
		 return String;
	}
}
