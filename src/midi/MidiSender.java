package midi;

import jm.JMC; 
import jm.midi.MidiCommunication;
import jm.music.data.Note;


public class MidiSender extends MidiCommunication implements JMC {

    public MidiSender(int i, int j) {
		super(i, j);
	}
    
    // Constructor for gui thing. We shouldn't be using this. (TODO)
    public MidiSender() {
    	super();
    }

	@Override
	public void handleMidiInput(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}	
	
	public synchronized void playNote(Note note) {
		// STATUS, CHANNEL, DATA1, DATA2
		
		this.sendMidiOutput(144, 0, note.getPitch(), note.getDynamic());
		System.out.println("Sent noteon Pitch = " + Integer.toString(note.getPitch()) + ", Dynamic = " + note.getDynamic() + " length = " +Double.toString(note.getDuration()));
		try {
			System.out.println("sleeping for "+note.getRhythmValue());
			Thread.sleep((long) (note.getDuration()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendMidiOutput(128, 0,  note.getPitch(), note.getDynamic());
		System.out.println("Sent noteoff");
		
		
	}
	
//	private void sendMidiOn(int status, int channel, int data1, int data2) {
//		
//		
//	}

}