package context;

import java.util.ArrayList;
import voice.VoiceManager;

public class ContextManager {
	
	private ArrayList<Context> contextList;
	private VoiceManager voiceManager;	// TODO : Do we need a reference to VoiceManager?
	
	public ContextManager(ArrayList<Context> contextList) {
		this.contextList = contextList;
	}
}
