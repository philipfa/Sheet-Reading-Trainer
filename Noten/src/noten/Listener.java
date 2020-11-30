package noten;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.DeviceThatWillTransmitMidi;
import org.jfugue.Pattern;

public class Listener {
	public static Pattern listen() {
	DeviceThatWillTransmitMidi device = null;
	 try {
	 device = new DeviceThatWillTransmitMidi();
	 } catch (MidiUnavailableException e) {
	 // handle MIDI Unavailable Exception
	 } 
	 System.out.println("Listening for 5 seconds...");
	 device.startListening();

	 // Wait long enough to play a few notes on the keyboard
	 try {
	 Thread.sleep(5000);
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
