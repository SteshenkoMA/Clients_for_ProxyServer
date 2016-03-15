# Clients for ProxyServer
Три вида Clients для ProxyServer (**REST**,  **Websockets**,  **Sockets**)

В классах Client...Test в цикле for создаются несколько экземпляров соответствующих Clients.    
И одновременно посылаются зашифрованные сообщения на ProxyServer, обратно возвращается ответ со статусом
![clients](https://cloud.githubusercontent.com/assets/13558216/13790731/5621f8b4-eb03-11e5-9147-622e32c5bbfe.JPG)
Three variants of Clients for ProxyServer (**REST**, **Websockets**, **Sockets**)    

The multiple instances of Clients are created in the for loop in Client...Test classes.
And encrypted are send to ProxyServer at the same time, it returns back a response with the status.    
