package clients.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author BigMax
 */
public class ClientRest implements Runnable {
    
	   private String inputBase64;
	   private String serverResponse;
	 
	   	    
	    StringBuilder output = new StringBuilder();
	    	    
   	   			    
	    ClientRest (String inputBase64){
	    	this.inputBase64 = inputBase64;
	    	run();	    	
		}
	    
	 
	    
	     
		public void run() {
	      try {
				String url = "http://localhost:8080/ProxyServer_REST_Websockets_Sockets/App/Ticket/"+inputBase64;
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
						        
				con.setRequestMethod("GET");
			
			    BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
				    response.append(inputLine);
				}
				in.close();
					
				serverResponse= response.toString();
												
				System.out.println(serverResponse);

			}
			catch (Exception e) {

			}
		 
		 
	}
	
	
}
	 
