package context;

import java.util.ArrayList;

import jm.music.data.Note;

public class ContextManager {
	
	public Context c1;
	public Context c2;
	public Context c3;
	public ContextLoader loader;
	
	public ArrayList<Float> contextPosition;	// TODO : Probably change this whole system (is vectors better?) a more robust way of ensuring everything adds up to 100. However, if editing functions are written correctly this won't matter
	
	public ContextManager(){
		
		loader = new ContextLoader();
		contextPosition = new ArrayList<Float>();
		
		for (int i =0; i<loader.numContexts; i++) {
			contextPosition.add(0f);
		}
		contextPosition.set(0, 1f);	// Set our current context to context1 by default
		
		// Create some note arrays for our manual contexts
		Note[] n1 = {new Note(32, 5.0),
					new Note(35, 5.0),
					new Note(40, 5.0)
					};
		
		Note[] n2 = {new Note(12, 7.0),
					new Note(20, 7.0),
					new Note(45, 2.0),
					new Note(50, 1.0),
					new Note(40, 1.0),
					new Note(55, 1.2)
		};
		
		Note[] n3 = {new Note(14, 7.0),
				new Note(40, 7.0),
				new Note(60, 2.0),
				new Note(23, 1.0),
				new Note(32, 1.0),
				new Note(39, 1.2)
		};
		
		
		
		// Testing code. Creating manual contexts.
		c1 = new Context("death-note-melody.mid");
		//c1.Init(0.2f, 1, 0.9f, 0.1f, 0.1f, 0.1f, n1);	// A "peaceful" context
		//c2 = new Context("empty");
		//c2.Init(0.5f, 2, 0.6f, 0.2f, 0.5f, 0.5f, n2); 	// Things are happening
		//c3 = new Context("empty");
		//c3.Init(0.8f, 3, 0.3f, 0.7f, 0.9f, 0.9f, n3);	// Madness. Its all kicking off
	}
	
	// Should return a context object?
	void getVirtualContext(){
		
		int numContexts = loader.numContexts;
		
		
	}
}
