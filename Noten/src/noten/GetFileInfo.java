package noten;

import java.io.File;  // Import the File class

public class GetFileInfo { 
  public String FileInfo(String filename) {
    File myObj = new File(filename);
    if (myObj.exists()) {
    	return myObj.getName();
    } else {
      return "The file does not exist.";
    }
  }
}
