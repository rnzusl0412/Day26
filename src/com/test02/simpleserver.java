package com.test02;

import java.io.*;
import java.net.*;

public class simpleserver {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket serviceSocket;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
		}
		while (true) {

			try {
				System.out.println("Client�� ��ٸ��ϴ�...");
				serviceSocket = serverSocket.accept();
				System.out.println("Client�� �����Ͽ����ϴ�...");
				out = new PrintWriter(serviceSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					out.println(inputLine);
				}
				out.close();
				in.close();
				serviceSocket.close();
				System.out.println("Client�� ������ �����߽��ϴ�...");
			} catch (Exception e) {

			}
		}
	}

	public simpleserver() {
	}
}
