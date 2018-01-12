package com.luxcm.netty.nio;

public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        String host = "127.0.0.1";
        new TimeClient().connect(port,host);
    }

    public void connect(int port, String host){
        new Thread(new TimeClientHandle(host, port),"TimeClient-001").start();
    }
}
