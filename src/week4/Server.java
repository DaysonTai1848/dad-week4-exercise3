package week4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author daysontai
 *
 */

public class Server {

	public static void main(String[] args) throws IOException {
		
		// Declare socket
		ServerSocket serverSocket = null;
		
		try {
			
			// Bind Serversocket to a port
			int portNo = 4800;
			serverSocket = new ServerSocket(portNo);
			
			// Server waiting for client to send request
			System.out.println("Waiting for request");
			
			while(true) {
				
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
							
				// create input stream
				InputStreamReader inputStream = 
						new InputStreamReader(clientSocket.getInputStream());
				
				BufferedReader bufferedReader = new BufferedReader(inputStream);
				
				// Get text from client
				String text = bufferedReader.readLine();
				
				// Get number of words
				int numberOfwords = text.length();
				
				// Create output stream
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());
			
				// Send translated text back to client 
				outputStream.writeInt(numberOfwords);
				
				// Close socket
				clientSocket.close();
				
			}
		} catch (IOException ioe) {
			if (serverSocket != null) {
				serverSocket.close();
			}
			
			ioe.printStackTrace();
		}
		
	}

}
