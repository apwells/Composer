import grame.midishare.*;

public class Share {
	
	public static void main(String args[]) {
		// set these how you want them
		int outport = 2;
		int channel = 2;
		int pitch = 60;
		int vel = 120;

		int installed = 0;
		try {
			installed = Midi.Share();
		} catch (UnsatisfiedLinkError e) {
			e.printStackTrace();
			System.out.println(
				"\nMidiShare Java API probably not installed properly, grame.midishare.Midi.Share() barfed.\n" + e);
			System.exit(0);
		}

		System.out.println("installed = " + installed);
		int version = Midi.GetVersion();
		System.out.println("version = " + version);
		int numberOfAppl = Midi.CountAppls();
		System.out.println("numberOfAppl = " + numberOfAppl);
		int ourRefNum = Midi.Open("SimpleMidiShareTest");
		numberOfAppl = Midi.CountAppls();
		System.out.println("our ref #= " + ourRefNum + ", numberOfAppl = " + numberOfAppl);

		StringBuffer text = new StringBuffer();
		short i;
		int ref, n = Midi.CountAppls();
		text.append("List of MidiShare client applications\n");
		text.append("-------------------------------------\n");
		for (i = 1; i <= n; i++) {
			ref = Midi.GetIndAppl(i); // get the refnum form the order number
			text.append(String.valueOf(i));
			text.append(" : reference number ");
			text.append(String.valueOf(ref));
			text.append(" name : ");
			text.append(Midi.GetName(ref));
			text.append("\n");
		}
		text.append("-------------------------------------");
		System.out.println(text.toString());

		Midi.Connect(ourRefNum, 0, 1);
		int connected = Midi.IsConnected(ourRefNum, 0);
		System.out.println("Connected? " + connected);

		for (int interval = 0; interval < 12; interval++) {
			int event = Midi.NewEv(Midi.typeKeyOn); // ask for a new note event
			if (event != 0) { // if the allocation was succesfull
				Midi.SetChan(event, channel); // set the Midi channel
				Midi.SetPort(event, outport); // set the destination port
				Midi.SetField(event, 0, pitch + interval); // set the pitch field
				Midi.SetField(event, 1, vel); // set the velocity field
				Midi.SendIm(ourRefNum, event);
			}
			System.out.println("Sent Midi note on " + (pitch + interval));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}

			event = Midi.NewEv(Midi.typeKeyOff);

			if (event != 0) {
				Midi.SetChan(event, channel);
				Midi.SetPort(event, outport);
				Midi.SetField(event, 0, pitch + interval);
				Midi.SetField(event, 1, vel);
				Midi.SendIm(ourRefNum, event);
			}
			System.out.println("Sent Midi note off " + (pitch + interval));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
		Midi.Close(ourRefNum);
	}

}
