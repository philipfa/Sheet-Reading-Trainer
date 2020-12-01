package sheet_Trainer;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class GetFileInfo {
  public String FileName(String File) {
    try {
      File myObj = new File(File);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        return data;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return "An error accured";
    }

    return "An error accured";
  }
}