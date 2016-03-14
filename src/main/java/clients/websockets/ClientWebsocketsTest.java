package clients.websockets;

public class ClientWebsocketsTest {

	public static void main(String[] args) {
				
		  // 1 TBV|25612617 LdXfcPDpzQWbQC6RXf0TQBkuVbS5jj7W3cSAJz5dF4g=
	      // 2 PFA|999999   8nR3Lf29iZ7gCxt/0z4WcrC35FeVxXLtbaUzfgJi0FY=
	      // 3 BND|111      hNwEjTLFL0JBzRv6x2WaRI54jF9mU5oQZ6zBcKxvT3U=
		
		  for(int i=0;i<=50;i++){
	            buildClient(i, 1, "LdXfcPDpzQWbQC6RXf0TQBkuVbS5jj7W3cSAJz5dF4g=");
	            buildClient(i, 2, "8nR3Lf29iZ7gCxt/0z4WcrC35FeVxXLtbaUzfgJi0FY=");
	            buildClient(i, 3, "hNwEjTLFL0JBzRv6x2WaRI54jF9mU5oQZ6zBcKxvT3U=");
	        }
				
				  for(int i=0;i<=50;i++){
			            buildClient(i, 1, "DCYdmCQ04z9E0k1oyIxxtmE6QZaBBeA3SQoV8SLQFGw=");
			            buildClient(i, 2, "DxroUb/lZ9kUlHgK+IOS3qH4gumyZLnKd1gh51Qa37Q=");
			            buildClient(i, 3, "zUwbaEOFbzUwma5xcGhoKaETXrhCDWrTNoaSRLlIm98=");
			        }
		

	    }
	
	 public static void buildClient(int id, int subId, String messageInputBase64){

	       Thread one = new Thread() {
	            public void run() {
	                try {
	                    System.out.println("Started thread " + id + "."+subId+ " at "+ System.currentTimeMillis());

	                    new ClientWebsockets (messageInputBase64);

	                    System.out.println("Ended thread " + id + "."+subId+ " at "+ System.currentTimeMillis());
	                    
	                }catch (Exception ex) {
	                   
	                } 
	            }
	        };

	       one.start();


	    }

}
