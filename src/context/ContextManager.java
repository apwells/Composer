package context;

import java.util.ArrayList;
import java.util.Random;

import jm.music.data.Note;
import voice.VoiceManager;

public class ContextManager {
	
	private ArrayList<Context> contextList;
	public ContextDistanceMatrix distanceMatrix;
	public ContextListener contextListener;
	
	public ContextManager(ArrayList<Context> contextList) {
		this.contextList = contextList;
		distanceMatrix = new ContextDistanceMatrix(contextList, this);
		contextListener = new ContextListener(distanceMatrix);
	}
	
	public Context getContextByProbability() {
		
		return null;
	}
	
	/*
	 *  Will return a line taking into account the contexts distances. Concentrate on this function.
	 *  This will be return a line, the probabilities are based on the distances.
	 *  Will sometimes return null if there are more contexts than line choices and probability doesn't favour line.
	 */
	public Line getLine(ArrayList<Line> lineList) {
		
		Random rnd = new Random();
		double p = rnd.nextDouble();
		double cumulativeProbability = 0.0;
		for (Line line : lineList) {
		    cumulativeProbability += distanceMatrix.getContextDistance(line.getContextId())/100;
		    if (p <= cumulativeProbability) {
		        return line;
		    }
		}
		// Returns a null line if there are more choices than lines and a line is not picked by probability. In this case, we play a rest note.
		return null;
	}
	
	public Line getLineByName(String file) {
		for (Context context : contextList) {
			if (context.hasLineByName(file)) {
				return context.getLineByName(file);
			}
		}
		System.err.println("ERROR : getLineByName returned null. Someone is passing a faulty line filename");
		return null;
	}
	
	public Context getContextByName(String name) {
		for (Context context : contextList) {
			if (context.getName().equals(name)) {
				return context;
			}
		}
		System.err.println("ERROR : No context found with name " + name);
		return null;
	}
	
	public Context getContextDistanceByName(String name) {
		return null;
	}
	
	private Context getContextDistance(Context context) {
		return null;
	}
	
	public int getNumberOfContexts() {
		return contextList.size();
	}
}
