package sheet_Trainer;

import java.awt.*;
import java.util.*;

import javax.sound.midi.*;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfugue.*;

public class Main extends Canvas{

    public static String random() {
    	Random rand = new Random();
    	int upperbound = 24;
    	int int_random = rand.nextInt(upperbound) +1;
    	switch (int_random) {
    	case 1: return "A3";
    	case 2: return "H3";
    	case 3: return "C4";
    	case 4: return "D4";
    	case 5: return "E4";
    	case 6: return "F4";
    	case 7: return "G4";
    	case 8: return "A4";
    	case 9: return "H4";
    	case 10: return "C5";
    	case 11: return "D5";
    	case 12: return "E5";
    	case 13: return "F5";
    	case 14: return "G5";
    	case 15: return "A5";
    	case 16: return "H5";
    	case 17: return "C6";
    	case 18: return "D6";
    	case 19: return "E6";
    	case 20: return "F6";
    	case 21: return "G6";
    	case 22: return "A6";
    	case 23: return "A6";
    	case 24: return "C7";
    	default: return "Fehler";
    	}
    }

	public static String currentImage = random();
    public void paint(Graphics g) {  
  	  
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("Assets\\" + currentImage + ".jpg");
        g.drawImage(i, 200,200,this);  
    } 
    
	
	public static void main(String[] args)  {
		//Setup
		Setup setup = new Setup();
		if (setup.FileAvalible("time.txt") == false) {
			JOptionPane.showMessageDialog(null,
					"\"Time.txt\" not found" + System.lineSeparator() + "Please reinstall the Programm or contact the Administrator","Error"
					,JOptionPane.ERROR_MESSAGE);
        	System.exit(0);
		}
		int exit = 0;
		while (exit == 0) {
			MakeSound MakeSound = new MakeSound();
			Player player = new Player();
			
		    String StringPattern = currentImage;
		    Pattern pattern = new Pattern(StringPattern);
		    player.play(pattern);
		    
		    Main Main =new Main();  
		    JFrame Frame =new JFrame();  
		    Frame.add(Main);  
		    Frame.setSize(400,400);  
		    Frame.setVisible(true);  
		    
		    String SheetOut = sheet_Trainer.Converter.ConvertToString(sheet_Trainer.JFugue.listen());
		    System.out.println(SheetOut);
			System.out.println(currentImage);
			int firstIndex = SheetOut.indexOf(currentImage);
		 	System.out.println(firstIndex);
		 	
			if (firstIndex > 0) {
				 System.out.println("Jaaay");
			 	 MakeSound.playSound("Assets\\tada.wav");
			 	 Frame.dispose();
			}
			else
				Frame.dispose();
			firstIndex = SheetOut.indexOf("C8");
			if (firstIndex > 1)
				exit = 1;
			currentImage = random();
		}
	} 
}