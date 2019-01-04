package com.test01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket02 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8910);
		while (true) {
			Socket sock = server.accept();
			InetAddress addr = sock.getInetAddress();
			System.out.println("Connection made to " + addr.getHostName() + " (" + addr.getHostAddress() + ")");

			InputStream r = sock.getInputStream();
			System.out.println("보내온 메세지 : " + r.read());
			OutputStream o = sock.getOutputStream();
			o.write("조금 있다 쉬자.".getBytes());

			Thread.sleep(500);
			o.close();
			r.close();
			sock.close();
		}
	}
}
