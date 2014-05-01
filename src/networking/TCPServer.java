package networking;

import java.io.*;
import java.net.*;

import context.ContextListener;

public class TCPServer extends Thread {

	private ContextListener contextListener;
	private int port = 6789; // TODO : This should be set in settings?

	public TCPServer(ContextListener contextListener) {
		this.contextListener = contextListener;
	}

	public void run(){
		String clientSentence;
		String capitalizedSentence;
		try {
			ServerSocket welcomeSocket = new ServerSocket(port);
			System.out.println("TCPServer is running on port " + port);
			while (true) {
				Socket connectionSocket = welcomeSocket.accept();
				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(
						connectionSocket.getOutputStream());
				clientSentence = inFromClient.readLine();
				System.out.println("Received: " + clientSentence);
				onMessage(clientSentence);
				//capitalizedSentence = clientSentence.toUpperCase() + '\n';
				//outToClient.writeBytes(capitalizedSentence);

			}
		} catch (Exception e) {
			System.err.println("Exception in TCP Server : " + e);
		}
	}


	public void onMessage(String message) {
		contextListener.onMessage(message);
	}
}