import jm.JMC; 
import jm.midi.MidiCommunication;

public class MidiTest extends MidiCommunication implements JMC {

    public MidiTest(int i, int j) {
		super(i, j);
	}

	public static void main(String[] args) {
        MidiTest mt = new MidiTest(0, 1);
        
        mt.sendMidiOutput(144, 2, 61, 100);	// WORKS WITH B4
        //mt.sendMidiOutput(144, 2, 60, 100);
    }	

    public void handleMidiInput(int status, int channel, int data1, int data2) {
        System.out.println(status + " " + channel + " " + data1 + " " + data2);
    }
}