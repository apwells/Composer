import context.ContextLoader;
import context.ContextManager;
import jm.music.rt.*;
import jm.audio.*;
import jm.music.data.*;


public class RealtimeMelody extends RTLine {

	//ContextLoader loader = new ContextLoader();
	//Score score;
	
	ContextManager manager;
	
	public RealtimeMelody(Instrument[] inst) {
		super (inst);
		manager = new ContextManager();
		//score = loader.getContext(1).theScore.copy();
		
	}
	
	// required method overrided
	public Note getNextNote() {
		
		
		
		
		//return score.getPart(0).getPhrase(0).getNote(1);
		
		return manager.c1.getNextNote();
		
//		return new Note (	
//							(int)(Math.random() * 60 + 30), 0.25,
//							(int)(Math.random() *100 +27)
//						);
		
		
	}
	
}
