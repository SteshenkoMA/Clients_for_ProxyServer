package clients.websockets;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;


import javax.websocket.ClientEndpointConfig;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;


public class ClientWebsockets {
	
	private CountDownLatch messageLatch;
	private  String message;
	 
	ClientWebsockets (String message){
		this.message = message;
		connect();
	}
	
	public void connect() {
		try {
			messageLatch = new CountDownLatch(1);
			final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
					

			ClientManager client = ClientManager.createClient();
			client.connectToServer(
					new Endpoint() {

		                @Override
		                public void onOpen(Session session, EndpointConfig config) {
		                    try {
		                        session.addMessageHandler(new MessageHandler.Whole<String>() {

		                            @Override
		                            public void onMessage(String message) {
		                                System.out.println("Received message: " + message);
		                                messageLatch.countDown();
		                            }
		                        });
		                        session.getBasicRemote().sendText(message);
		                    } catch (IOException e) {
		                        e.printStackTrace();
		                    }
		                }
		            }, cec, new URI("ws://localhost:8080/ProxyServer_REST_Websockets_Sockets/proxyserver"));
		        //  messageLatch.await(100, TimeUnit.SECONDS);
		          messageLatch.await();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	}

	
}