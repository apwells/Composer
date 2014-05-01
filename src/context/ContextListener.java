package context;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import networking.TCPServer;

import utility.Command;


// This class should really be static, or atleast the TCPserver should be a static class. We're only ever going to have 1 context listnener anywa, but still TODO
public class ContextListener{

	private ContextDistanceMatrix contextDistanceMatrix;
	private static TCPServer tcpServer;	// TODO : Check that making this static is ok
	
	public ContextListener(ContextDistanceMatrix contextDistanceMatrix) {
		this.contextDistanceMatrix = contextDistanceMatrix;
		tcpServer = new TCPServer(this);
		tcpServer.start();
	}

	
	public void onMessage(String message) {
		Command command = Command.readCommand(message);
		if (command == null) {
			System.out.println("ERROR: Message " + message + " is an invalid command");
			return;
		}
		contextDistanceMatrix.applyCommand(command);
		// System.out.println("ContextListener : Command Applied - " + message);
	}

}
