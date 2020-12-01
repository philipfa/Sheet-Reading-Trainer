package sheet_Trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Setup {
	  public static boolean FileAvalible(String File) {
		    try {
		      File myObj = new File(File);
		      Scanner myReader = new Scanner(myObj);
		    } catch (FileNotFoundException e) {
		      return false;
		    }

		    return true;
		  }
}
