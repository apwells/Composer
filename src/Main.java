import voice.VoiceManager;
import midi.MidiSender;
import context.Context;
import context.ContextManager;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class Main {
	
	public static void main(String[] args){
		
		Settings settings;
		ContextManager contextManager;
		VoiceManager voiceManager;
		
		settings = new Settings("Soundtrack1");
		contextManager = settings.getContextManager();
		voiceManager = settings.getVoiceManager();
		
//		ContextManager cManager = new ContextManager();
//
//		ContextThread player1 = new ContextThread(cManager.c1);
//		ContextThread player2 = new ContextThread(cManager.c2);
//
//		player1.start();
//		player2.start();
		
		// Little test
//		Phrase phrase = new Phrase();
//		Part part = new Part();
//		Score score = new Score();
//		for (int x =0; x < 30; x++) {
//			phrase.add(cManager.c1.getNextNote());
//			
//		}
//		part.add(phrase);
//		score.add(part);
//		View.show(score);
//		Write.midi(score, "m1.mid");
		// END LITTLE TEST
		
//			}


		
	}
}
