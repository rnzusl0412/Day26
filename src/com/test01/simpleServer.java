package com.test01;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null;
		Socket serviceSocket;
		OutputStream os;
		DataOutputStream dos;
		serverSocket = new ServerSocket(7777);
		System.out.println("클라이언트 접속을 기다리고 있습니다.");
		while (true) {
			try {
				serviceSocket = serverSocket.accept();
				System.out.println("클라이언트가 접속되었습니다.");
				os = serviceSocket.getOutputStream();
				dos = new DataOutputStream(os);

				dos.writeUTF("Hello Java Net !");
				dos.close();
				os.close();
				serviceSocket.close();
			} catch (Exception e) {

			} finally {
				serverSocket.close();
			}
		}
	}
}
