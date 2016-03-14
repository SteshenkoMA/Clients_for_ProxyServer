package clients.sockets;

import java.net.*; 
import java.io.*; 

 
public class ClientSockets
{ 
	String inputBase64;
	
	ClientSockets(String inputBase64){
		this.inputBase64 = inputBase64;
		runClient();
	}
  
    public void runClient()
    
    { 
    	     
        Socket s = null; 
        
        // Соединяемся с сервером
        try 
        { 
        	String address = "127.0.0.1";
    	    InetAddress ipAddress = InetAddress.getByName(address);
    	    
            s = new Socket(ipAddress, 11111); 
        }        
        catch(UnknownHostException uhe) 
        {             
            System.out.println("Не удалось подключиться к серверу"); 
            s = null; 
        } 
        catch(IOException ioe) 
        { 
            System.out.println("Невозможно подсоединиться к порту"); 
            s = null; 
        } 
        
        if(s == null) 
            System.exit(-1); 
        
        BufferedReader in = null; 
        PrintWriter out = null; 
        
        try 
        { 
            // Потоки для получения информации
            in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream())); 
            
            // Отсылаем зашифрованное сообщение inputBase64
            out.println(inputBase64); 
            out.flush(); 
            // Считывавем ответ сервера
            String serverResponse = in.readLine();
            
            System.out.println(serverResponse); 
            
            } 
        catch(IOException ioe) 
        { 
            System.out.println("Сервер закрыл соединение"); 
        } 
        finally 
        { 
            try 
            { 
                // Закрываем потоки чтения информации
                out.close(); 
                in.close(); 
                // Закрываем сокет 
                s.close(); 
            } 
            catch(Exception e) 
            { 
                e.printStackTrace(); 
            }                
        }        
    } 
}

