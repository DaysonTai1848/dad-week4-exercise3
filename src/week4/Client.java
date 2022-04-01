package week4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author daysontai
 *
 */

public class Client {

	public static void main(String[] args) {
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			
			// Connect to server at localhost
			int portNo = 4800;
			Socket socket = new Socket(InetAddress.getLocalHost(), portNo);
			
			// Enter text
			System.out.println("Enter text: ");
			
			// scan text
			String text = scanner.nextLine();
			
			// Create Output Stream
			DataOutputStream outputStream = 
					new DataOutputStream(socket.getOutputStream());
			
			// Write text into the outputstream 
			outputStream.writeUTF(text);
		
			
			// Create input stream
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			// Read from network and display the result 
			String result = bufferedReader.readLine();
			System.out.println(result);
			
			// Close everything
			bufferedReader.close();
			socket.close();
					
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
