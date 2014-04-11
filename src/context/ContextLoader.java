package context;
import java.util.ArrayList;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public class ContextLoader {
	
	int numContexts = 3;
	ArrayList<Context> contexts;	// Should probably be a hashmap, so composers can name their contexts?
	
	public ContextLoader() {
		
		contexts = new ArrayList<Context>();
		
//		for (int i=0; i<3; i++) {
//			
//		}
		//contexts.add(new Context("cmajor-lead-c1.mid"));
		//contexts.add(new Context("cmajor-lead-c2.mid"));
		//contexts.add(new Context("cmajor-lead-c3.mid"));
		
	}

	public Context getContext(int contextId) {
		return contexts.get(contextId);
	}
	
}
