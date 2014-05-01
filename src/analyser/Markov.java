package analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public class Markov implements JMC{
	
	private int order = 3;	// Test at 3
	private float randomness = 0.1f;	// This will reduce certainty.
	
	private static ArrayList<Note> workingList;
	
	//private static ArrayList<MarkovEntry> markovTable = new ArrayList<MarkovEntry>();	// TODO : This should be a hashmap.
	//private static HashMap<String, MarkovEntry> markovTable = new HashMap<String, MarkovEntry>
	
	private static HashMap<String, ArrayList<Note>> markovTable = new HashMap<String, ArrayList<Note>>();
	String currentPattern = "";
	
	/*
	 *  Tell us the order of the markov you want.
	 *  Perhaps we return an array of notes/states and probabilities?
	 */
	
	public Markov(int order, String midiFile) {
		midiFile = midiFile +".mid";
		Score midiScore = new Score("Temporary score");
		Read.midi(midiScore, midiFile);
		generateMarkov(midiScore, order);
		this.order = order;
		
		// Initialise our pattern with a random note from the piece
		Part part = midiScore.getPart(0);
		Phrase phrase = part.getPhrase(0);
		Random rnd = new Random();
		int note = rnd.nextInt(phrase.getSize());
		currentPattern = Integer.toString(phrase.getNote(note).getPitch());
	}
	
	/*
	 *  Using our current pattern, we look get the next note to use.
	 */
	public Note getNext() {
		
		while (!markovTable.containsKey(currentPattern)) {	// If we don't have an entry for that pattern.
			// System.out.println("Stripping pattern. Currently " + currentPattern);
			// strip off the first entry in pattern.
			if (currentPattern.equals("")) {
				System.out.println("NO PATTERN!");
				break;
			}
			String [] stripped = currentPattern.split(" ", 2);	// Strips first word.
			// System.out.println("Pattern was '" + currentPattern + "' now its '" + stripped[1]+"'");
			currentPattern = stripped[1];

		}
		
		ArrayList<Note> noteList = markovTable.get(currentPattern);
		Note addNote = getNextNote(noteList);
		currentPattern = currentPattern + " " + Integer.toString(addNote.getPitch());
		return addNote;
		
	}
	
//	public static void main(String[] args){
//
//    Score theScore = new Score("Temporary score");
//            
//	// read the MIDI files made earlier as input                
//	Read.midi(theScore, "death-note-melody.mid");
//	//View.show(theScore);
//	//System.out.println("PHRASE = " + theScore.getPart(0).getPhrase(0).length());
//	
//	//analyse(theScore);
//	generateMarkov(theScore, 1);
//	System.out.println("BUILDING SCORE---");
//	buildTestScore(theScore);
//    }
	
	/*
	 *  This is a recursive function. We start from the highest order and work down
	 */
	private static void generateMarkov(Score score, int order) {
		
		System.out.println("generatingMarkov order " + order);
		
		Part part = score.getPart(0);
		Phrase phrase = part.getPhrase(0);
		
		for (int x = 0; x <= phrase.length() - order; x++) {	// TODO : What happens if we play the last note... Where do we go from there? Wrap around? Then we need to use some modulus math
			// Generate our pattern string
			String pattern = "";
			for (int y = x; y <= x + order-1; y++) {
				pattern = pattern + " " +phrase.getNote(y).getPitch();	// TODO : This is gonna leave a preceding SPACE at the start... Fix
				pattern = pattern.trim();	// Remove trailing whitespace
			}
			
			System.out.println("Pattern is " + pattern);
			
			//String lastNote = "" + phrase.getNote(x+order-1).getPitch();
			Note lastNote = phrase.getNote(x+order-1);	// Isn't this simply "this note"
			Note nextNote = phrase.getNote((x+order)%(phrase.length()-1));	// Does this need "-1"?
			
			if (markovTable.containsKey(pattern)) {
				markovTable.get(pattern).add(nextNote); 
			} else {
				ArrayList<Note> tmpList = new ArrayList<Note>();
				tmpList.add(nextNote);
				markovTable.put(pattern, tmpList);
			}
			
//			for (ArrayList<Note> notes : markovTable.values()) {
//				System.out.println("Contents : ");
//				for (int j = 0; j < notes.size(); j++) {
//					System.out.println("   " + notes.get(j).getPitch());
//				}
//			}

		}
		
		if (order > 1) {
			generateMarkov(score, order-1);
		}
		
	}
	
	private static void buildTestScore(Score score, String output) {
		
		float randomness = 0.1f;
		
		Part part = score.getPart(0);
		Phrase phrase = part.getPhrase(0);
		
		Part newPart = new Part();
		Phrase newPhrase = new Phrase();
		
		String pattern = Integer.toString(phrase.getNote(0).getPitch());
		
		newPhrase.add(phrase.getNote(0));
		
		// Let's make a 31 note score
		for (int x =0; x < 20; x ++) {
			ArrayList<Note> noteList = markovTable.get(pattern);
			System.out.println("Looking at pattern " + pattern);
			
			
			
			//Random rnd = new Random();
			//Note addNote = noteList.get(rnd.nextInt(noteList.size())); // Stupid algorithm. Just adds the last one... Doesn't use probability yet. 
			Note addNote = getNextNote(noteList);
			
			newPhrase.add(addNote);	
			pattern = pattern + " " + Integer.toString(addNote.getPitch());
			while (!markovTable.containsKey(pattern)) {	// If we don't have an entry for that pattern.
				// strip off the first entry in pattern.
				String [] stripped = pattern.split(" ", 2);	// Strips first word.
				System.out.println("Pattern was '" + pattern + "' now its '" + stripped[1]+"'");
				pattern = stripped[1];
				if (pattern.equals("")) {
					System.out.println("NO PATTERN!");
					break;
				}
			}
			
		}
		
		newPart.add(newPhrase);
		Score newScore = new Score();
		newScore.add(newPart);
		
		View.show(newScore);
		Write.midi(newScore, output);
	}
	
	/*
	 *  TODO : No randomness/chance of picking random note from piece introduced yet. Just pure probability
	 */
	private static Note getNextNote(ArrayList<Note> noteList) {
		
		Random rnd = new Random();
		double p = rnd.nextDouble();
		System.out.println("RANDOM = " + p);
		//double p = Math.random();
		double cumulativeProbability = 0.0;
		double eachProb = 1.0 / noteList.size();
		for (Note note : noteList) {
		    cumulativeProbability += eachProb;
		    if (p <= cumulativeProbability) {
		    	
		        return note;
		    }
		}
		return null;	// This should never happen. Throw exception?
	}
	
	private static void analyse(Score score){
		
		workingList = new ArrayList<Note>();
		
		Part newpart = new Part();
		Phrase newphrase = new Phrase();
		
		Part part = score.getPart(0);
		Phrase phrase = part.getPhrase(0);
		// iterate through all the notes
		for (int x = 0; x < phrase.length(); x++) {
			Note note = phrase.getNote(x);
			newphrase.add(note);
			workingList.add(note);	// Add all our notes to our workinglist
		}
		
		for (Note note1: workingList ){
			for (Note note2: workingList) {
				if (note1.getPitch() == note2.getPitch()) {
					// They are the same pitch.
					
				}
			}
		}
		
		newpart.add(newphrase);
		
		Score newscore = new Score();
		newscore.add(newpart);
		
		View.show(newscore);
		Write.midi(newscore, "variation1.mid");
		
	}
        

}
