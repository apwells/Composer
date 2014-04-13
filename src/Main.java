import midi.MidiSender;
import context.Context;
import context.ContextManager;
import context.ContextThread;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class Main {
	
	
	public static void main(String[] args){
		
		ContextManager cManager = new ContextManager();
		//MidiSender midi = new MidiSender(0,1);

		ContextThread player1 = new ContextThread(cManager.c1);

			//if (player1.getState() == Thread.State.NEW) {

			player1.start();
//			}


		
	}
}
