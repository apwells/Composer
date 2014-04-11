package analyser;

/*
 *  A simple class that is our pair type for our markov table. Simply (noteId, probability)
 */

public class NotePair {

	private int noteId;
	private float prob;
	
	public NotePair(int noteId, float prob) {
		this.noteId = noteId;
		this.prob = prob;
	}

	public int getNoteId() {
		return noteId;
	}

	public float getProb() {
		return prob;
	}
	
}
