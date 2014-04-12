package context;
import java.util.Random;

import analyser.Markov;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public final class Context implements JMC{
	
	String source;
	public Score theScore;
	private Markov markov;
	
	Note[] noteArray;
	float variation;
	int voices;
	float repetition;
	float discord;
	float excitement;
	float thickness;
	
	// Take a file as input. Get it's notes/parts
	// Later on we should make the source file denote our context variables through some clever analysis of its contents (idea)
	public Context(String source) {
		this.source = source;
		this.theScore = new Score("ContextScore");
		this.markov = new Markov(1, source);
		
		// Read.midi(theScore, source);
		// Part tempPart = theScore.getPart(0);
		
		// View.show(theScore);
		
	}
	
	// Initialize our variables
	public void Init(float variation, int voices, float repetition, float discord, float excitement, float thickness, Note[] noteArray) {
		this.variation = variation;
		this.voices = voices;
		this.repetition = repetition;
		this.discord = discord;
		this.excitement = excitement;
		this.thickness = thickness;
		this.noteArray = noteArray;
	}
	
	// Complex algorithm...
	public Note getNextNote() {
//		Random rnd = new Random();
//		int note = rnd.nextInt(512) % noteArray.length;	// Should mod to size;
//		System.out.println("Note : "+note);
//		return noteArray[note];
		return markov.getNext();
	}
	
	

}
