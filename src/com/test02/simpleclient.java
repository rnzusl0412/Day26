package com.test02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class simpleclient implements Runnable {
	Socket clientSocket;
	PrintWriter out;
	BufferedReader in;
	BufferedReader stdin;

	public static void main(String[] args) {
		Thread t1 = new Thread(new simpleclient());
		Thread t2 = new Thread(new simpleclient());
		t1.run();
		t2.run();
	}

	public simpleclient() {
		super();
	}

	public void run() {
		try {
			System.out.println("sever에 접속합니다...");
			clientSocket = new Socket("127.0.0.1", 9999);

			out = new PrintWriter(clientSocket.getOutputStream(), true);

			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			stdin = new BufferedReader(new InputStreamReader(System.in));

			String inputLine;
			while ((inputLine = stdin.readLine()) != null) {
				out.println(inputLine);
				System.out.println("server: " + in.readLine());
			}
			out.close();
			in.close();
			stdin.close();
			clientSocket.close();
			System.out.println("소켓을 닫습니다...");
		} catch (Exception e) {

		}
	}
}