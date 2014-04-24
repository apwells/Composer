package midi;

import jm.JMC;
import jm.music.data.Note;

public class Tester implements JMC{
	
	public static void main(String[] args) {
		MidiSender sender = new MidiSender(0,1);
		Note n = new Note(52, 1.0, Note.DEFAULT_DYNAMIC-1);
		Note n2 = new Note(64, 4.5);
		Note n3 = new Note(75, 1.5);
		Note n4 = new Note(86, 2.5);
		sender.playNote(n);
		sender.playNote(n2);
		sender.playNote(n3);
		sender.playNote(n4);
	}

}
