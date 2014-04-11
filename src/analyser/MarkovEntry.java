package analyser;

import java.util.ArrayList;

import jm.music.data.Note;

/*
 *  A simple class that defines our Markov table entry. Better than using lots of arraylists
 *  Each entry is formed : Pattern -> Following Notes, Frequency of pattern
 */

public class MarkovEntry {
	
	private String pattern;	// In the form C5 C6 (space as delimiter. Simple to decode using java)
	//private ArrayList<NotePair> precedingNotes; // TODO : As we're not (?) using probabilities here anyway, this can just be an integer now representing the ID of the note in the original score.
	private ArrayList<Note> followingNotes;
	private int frequency = 1;	// This cannot start lower than 1
	
	
	public MarkovEntry(String pattern, Note followingNote) {
		this.pattern = pattern;
		followingNotes.add(followingNote);
	}
	
	// TODO: Getters for all, no setters (we can just have incrementFrequency function)
	// TODO: addFollowing(NoteId) function

}
