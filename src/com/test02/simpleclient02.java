package com.test02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class simpleclient02 extends Thread {
	Socket clientSocket;
	PrintWriter out;
	BufferedReader in;
	BufferedReader stdin;

	public static void main(String[] args) throws Exception {
		simpleclient02 t1 = new simpleclient02("具克捞");
		simpleclient02 t2 = new simpleclient02("港港捞");
		t1.start();
		t2.start();
	}

	public simpleclient02(String string) {
		super(string);
	}

	public void start() {
		try {
			System.out.println("sever俊 立加钦聪促...");
			clientSocket = new Socket("127.0.0.1", 9999);

			out = new PrintWriter(clientSocket.getOutputStream(), true);

			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			stdin = new BufferedReader(new InputStreamReader(System.in));

			String inputLine;
			while ((inputLine = stdin.readLine()) != null) {
				out.println(inputLine);
				System.out.println(getName() + " server: " + in.readLine());
			}
			out.close();
			in.close();
			stdin.close();
			clientSocket.close();
			System.out.println("家南阑 摧嚼聪促...");
		} catch (Exception e) {

		}
	}

}