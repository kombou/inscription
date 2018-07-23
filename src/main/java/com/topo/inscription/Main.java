package com.topo.inscription;

import com.topo.inscription.server.Server;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class Main {

    public static void main(String argv[]) throws ServletException, LifecycleException {
        Server.getInstance().start();
    }
}
