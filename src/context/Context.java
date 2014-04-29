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

	public Context(String name, ArrayList<Line> lineList) {
		this.name = name;
		this.lineList = lineList;
	}

}
