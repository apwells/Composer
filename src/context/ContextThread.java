package context;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.View;
import jm.util.Write;
import midi.MidiSender;

public class ContextThread extends Thread{
	
	private Context context;
	private MidiSender midi;
	
	public ContextThread(Context context) {
		this.context = context;
		this.midi = new MidiSender();
	}
	
	public void run() {
		int x = 0;
		
		Part part = new Part();
		Phrase phrase = new Phrase();
		
		while (this.getState() != Thread.State.TIMED_WAITING) {
			System.out.println("--- Calling ---" + Math.random());

			Note note = context.getNextNote();
			//Play.midi(note);
			//Play.
			phrase.add(note);
			System.out.println(note.toString());
			midi.playNote(note);
			x++;
		}
		part.add(phrase);
		Score score = new Score();
		score.add(part);
		View.show(score);
		Write.midi(score, "t1.mid");
		
	}

}
