package sheet_Trainer;


import javax.sound.midi.*;
import javax.swing.JOptionPane;

import org.jfugue.*;
import org.jfugue.Pattern;

public class JFugue {
	public static Pattern listen() {
		GetFileInfo f = new GetFileInfo();
		String time = f.FileName("time.txt");
		int numberInt = Integer.parseInt(time);
		System.out.println("Time " + numberInt);
		
		DeviceThatWillTransmitMidi device = null;
		 try {
		 device = new DeviceThatWillTransmitMidi();
		 } catch (MidiUnavailableException e) {
             JOptionPane.showMessageDialog(null,
                     "Midi device not found" + System.lineSeparator() + "Check if another Programm acceses you Midi device","Error"
                     ,JOptionPane.ERROR_MESSAGE);
             
             System.exit(0);
		 } 
		 System.out.println("Listening for 5 seconds...");
		 device.startListening();
	
		 // Wait long enough to play a few notes on the keyboard
		 try {
		 Thread.sleep(numberInt);
		 } catch (InterruptedException e)
		 {
		 // handle Interrupted Exception
		 }
		 // Close the device (at program exit)
		 device.stopListening();
		 System.out.println("Done listening");
		 Pattern pattern = device.getPatternFromListening();
		 return pattern;
	}

}
