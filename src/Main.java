import java.util.Random;

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
		
		//settings = new Settings("SoundtrackDemo");
		settings = new Settings(args[0]);
		contextManager = settings.getContextManager();
		voiceManager = settings.getVoiceManager();
		
		voiceManager.runVoices();
		
//		while (true) {
//			try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			settings.reBuildVoices();
//			contextManager.contextListener.onMessage("SetContext Danger 99");
//			
//			try {
//			Thread.sleep(9000);
//		} catch (Exception e) {
//			
//		}
//			settings.reBuildVoices();
//			contextManager.contextListener.onMessage("SetContext Stealth 99");
//		}
		
//		while (true) {
//		try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		settings.reBuildVoices();
//		}
		// DELETE THIS BIT. TESTING DISTANCE MATRIX
//		while(true) {
//			contextManager.distanceMatrix.addPercentage(0, 6.6);
////			Random rnd = new Random();
////			int size = contextManager.getNumberOfContexts();
////			contextManager.distanceMatrix.setContext(rnd.nextInt(size), 100);
//			contextManager.distanceMatrix.printMatrix();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		// Testing using commands
//		while(true) {
//			contextManager.contextListener.onMessage("SetContext Stealth 100");
//			contextManager.distanceMatrix.printMatrix();
//			try {
//				Thread.sleep(9000);
//			} catch (Exception e) {
//				
//			}
//			contextManager.contextListener.onMessage("SetContext Danger 100");
//			contextManager.distanceMatrix.printMatrix();
//			try {
//				Thread.sleep(9000);
//			} catch (Exception e) {
//				
//			}
//		}
		
		
		
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
