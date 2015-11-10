import java.io.DataOutputStream;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class Data_IO {
	
	private String token; 			//Store token value
	
	/**
	 * Constructor to populate the token value
	 * 
	 * @param tok Enter value of the token
	 */
	Data_IO(String tok){
		token=tok;		
	}
	
	/**
	 * Get the input value from the server by using a POST request
	 * 
	 * @return long Value of query on returned by the server
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	public long getQuery() throws Exception {
		
		String url = "https://kueski.com/candidates/get_input";
		//Create URL from String
		URL obj = new URL(url);
		
		//Create connection to the above URL
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//Configure connection to use POST
		con.setRequestMethod("POST");
				
		//Construct parameter string
		String urlParameters = token;
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		
		//Get response code from server
		int responseCode = con.getResponseCode();
		
		//Print request status to standard output
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		
		//Create Scanner object to read server response
		Scanner in = new Scanner(con.getInputStream());
		StringBuffer response = new StringBuffer();
		
		//Read all values sent by server
		while (in.hasNext()) {
			String inputLine=in.nextLine();
			System.out.println(inputLine);
			response.append(inputLine);
		}
		
		//Close Scanner object
		in.close();
		
		//Get String representation of StringBuffer
		String res=response.toString();
		
		//Print result to standard output for debugging
		System.out.println(res);
		
		//Extract the query value by parsing values returned by the server
		String temp[]=res.split(",");
		String temp1[]=temp[1].split(":");
		String temp2[]=temp1[1].split("\"");
		
		//Return extracted query
		return(Long.parseLong(temp2[1]));
	}
	
	/**
	 * Writes output to the server by using a POST request
	 * 
	 * @param ans String to be written to the server
	 * @return none 
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	public void sendAnswer(String ans) throws Exception {

		String url = "https://kueski.com/candidates/send_solution";
		//Create URL from String
		URL obj = new URL(url);
		//Create connection to the above URL
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//Configure connection to use POST
		con.setRequestMethod("POST");
		
		//Construct parameter string
		String urlParameters =token+"&solution="+ans;
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		
		//Get response code from server
		int responseCode = con.getResponseCode();
		
		//Print request status to standard output
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		
		//Create Scanner object to read server response
		Scanner in = new Scanner(con.getInputStream());		
		StringBuffer response = new StringBuffer();
		
		//Read all values sent by server
		while (in.hasNext()) {
			String inputLine=in.nextLine();
			/*Display server response on standard output */
			System.out.println(inputLine);
			response.append(inputLine);
		}
		
		//Close Scanner object
		in.close();		
	}
}
