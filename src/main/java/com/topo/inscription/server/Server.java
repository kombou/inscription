package com.topo.inscription.server;

public class Server {
    private static Server instance = new Server();

    private Server(){}
    public static Server getInstance() {
        return instance;
    }

    public  void start() {

        AppServer appServer = new TomcatServer();
        appServer.create();
        appServer.configure();
        appServer.start();

    }
}
