package context;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


// This class should really be static, or atleast the TCPserver should be a static class. We're only ever going to have 1 context listnener anywa, but still TODO
public class ContextListener{
	
	
	
	private ContextLoader loader;
	
	public void main(ContextLoader loader) throws Exception {
		
		this.loader = loader;
		
		// TCP Server code
		
		int test = 0;
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence + test);
			test++;
			onMessage(clientSentence);
			// Do we need to return this to the client? Perhaps we should return a status message that comes form the onMessage event?
			//capitalizedSentence = clientSentence.toUpperCase() + '\n';
			//outToClient.writeBytes(capitalizedSentence);

		}
	}
	
	// TODO : Take the message, then edit the context manager's knowledge about our current virtual context
	
	public static void onMessage(String message) {
		
		String pattern = "(.*) (.*) [0-9]*";	// Matches patterns of the type STRING STRING NUM which is how our commands are formatted.
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(message);
		// Testing the regex
	      if (m.find( )) {
	          System.out.println("Found value: " + m.group(0) );
	          System.out.println("Found value: " + m.group(1) );
	          System.out.println("Found value: " + m.group(2) );
	       } else {
	          System.out.println("NO MATCH");
	       }
	   		
		System.out.println("Received : " + message);
	}

}
