### Writing the Echo server

All Netty servers require the following:

* **ChannelHandler** 
    this component implements the server’s processing of data received from the client—its business logic.

* **Bootstrapping** (at least one) — 
    this is the startup code that configures the server. 
    At a minimum, it binds the server to the port on which it will listen for connection requests.
    
   
#### Bootstrapping the server
    
* Bind to the port on which the server will listen for and accept incoming connection requests
* Configure Channels to notify an EchoServerHandler instance about inbound messages

**Server bootstrapping:**

* Create a ServerBootstrap instance to bootstrap and bind the server.
* Create and assign an NioEventLoopGroup instance to handle event processing, 
    such as accepting new connections and reading/writing data.
* Specify the local InetSocketAddress to which the server binds.
* Initialize each new Channel with an EchoServerHandler instance.
* Call ServerBootstrap.bind() to bind the server.
    
**Client bootstrapping:**   

* A Bootstrap instance is created to initialize the client.
* An NioEventLoopGroup instance is assigned to handle the event processing, 
    which includes creating new connections and processing inbound and outbound data.
* An InetSocketAddress is created for the connection to the server.
* An EchoClientHandler will be installed in the pipeline when the connection is established.
* After everything is set up, Bootstrap.connect() is called to connect to the remote peer.
    
**Running the example**
    
Here's what happens:

1. As soon as the client is connected, it sends its message: Hello, Netty!
2. The server reports the received message and echoes it to the client.
3. The client reports the returned message and exits.    
