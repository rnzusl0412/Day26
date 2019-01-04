package com.test01;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class simpleClient {
	public static void main(String[] args) throws IOException {
		Socket clientSocket = null;
		InputStream is = null;
		DataInputStream dis = null;
		clientSocket = new Socket("127.0.0.1", 7777);
		is = clientSocket.getInputStream();
		dis = new DataInputStream(is);

		String st = new String(dis.readUTF());
		System.out.println(st);
		dis.close();
		is.close();
		clientSocket.close();

	}
}
