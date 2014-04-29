package context;
import java.util.ArrayList;
import java.util.Random;

import analyser.Markov;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public final class Context{

	private ArrayList<Line> lineList;
	private int id;
	private String name;

	public Context(String name, ArrayList<Line> lineList, int id) {
		this.name = name;
		this.lineList = lineList;
		this.id = id;
		setLineContexts();
		System.out.println("Context created with id " + id);
	}
	
	private void setLineContexts(){
		for (Line line : lineList) {
			line.setContext(this);
		}
	}
	
	public boolean hasLineByName(String file) {
		for (Line line : lineList) {
			if (line.getFile().equals(file)) {
				return true;
			}
		}
		return false;
	}

	public Line getLineByName(String file) {
		for (Line line : lineList) {
			if (line.getFile().equals(file)) {
				return line;
			}
		}
		return null;
	}
	
	public ArrayList<Line> getLineList() {
		return lineList;
	}

	public int getId() {
		return id;
	}

}
