package clients.rest;

public class ClientRestTest {

	public static void main(String[] args) {
				
		  // 1 TBV|25612617 LdXfcPDpzQWbQC6RXf0TQBkuVbS5jj7W3cSAJz5dF4g=
	      // 2 PFA|999999   8nR3Lf29iZ7gCxt/0z4WcrC35FeVxXLtbaUzfgJi0FY=
	      // 3 BND|111      hNwEjTLFL0JBzRv6x2WaRI54jF9mU5oQZ6zBcKxvT3U=
		
		  for(int i=0;i<=50;i++){
	            buildClient(i, 1, "LdXfcPDpzQWbQC6RXf0TQBkuVbS5jj7W3cSAJz5dF4g=");
	            buildClient(i, 2, "8nR3Lf29iZ7gCxt/0z4WcrC35FeVxXLtbaUzfgJi0FY=");
	            buildClient(i, 3, "hNwEjTLFL0JBzRv6x2WaRI54jF9mU5oQZ6zBcKxvT3U=");
	        }
            

		
			
	}

	 public static void buildClient(int id, int subId, String messageInputBase64){

	       Thread one = new Thread() {
	            public void run() {
	                try {
	                    System.out.println("Started thread " + id + "."+subId+ " at "+ System.currentTimeMillis());

	                    new ClientRest (messageInputBase64);

	                    System.out.println("Ended thread " + id + "."+subId+ " at "+ System.currentTimeMillis());
	                    
	                }catch (Exception ex) {
	                   
	                } 
	            }
	        };

	       one.start();


	    }
}
