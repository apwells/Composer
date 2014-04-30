package context;

import java.util.ArrayList;
import java.util.Random;

import jm.music.data.Note;
import voice.VoiceManager;

public class ContextManager {
	
	private ArrayList<Context> contextList;
	public ContextDistanceMatrix distanceMatrix;
	
	public ContextManager(ArrayList<Context> contextList) {
		this.contextList = contextList;
		distanceMatrix = new ContextDistanceMatrix(contextList);
	}
	
	public Context getContextByProbability() {
		
		return null;
	}
	
	/*
	 *  Will return a line taking into account the contexts distances. Concentrate on this function.
	 *  This will be return a line, the probabilities are based on the distances.
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
