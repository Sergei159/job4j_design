package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isWorking = true;
            while (isWorking) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello\r\n\r\n".getBytes());
                            break;
                        } else if (str.contains("Exit")) {
                            out.write("HTTP/1.1 522\r\n\r\n".getBytes());
                            out.write("Bye\r\n\r\n".getBytes());
                            isWorking = false;
                            break;
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("What\r\n\r\n".getBytes());
                        }
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
            LOG.error(" unable to connect to server ", e);
        }
    }
}