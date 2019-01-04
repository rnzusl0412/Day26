package com.test04;

import java.io.*;
import java.net.Socket;

public class ServiceThread extends Thread {
	private ChatServer server;
	private Socket socket;
	String UserName;
	PrintWriter out;
	BufferedReader in;

	public ServiceThread(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
	}

	public void sendMessage(String str) throws IOException {
		if (out != null)
			out.println(str);
	}

	public void run() {
		try {
			System.out.println("Ŭ���̾�Ʈ \n" + socket + "\n���� �����Ͽ����ϴ�."); // �޼��� ����� ��ü�� ���Ͽ��� �޾ƿ´�.
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out.println();
			out.println(UserName);
			UserName = in.readLine();
			sendMessage(UserName);
			server.sendMessageAll("#" + UserName + " ���� �����̽��ϴ�.");
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				server.sendMessageAll("[" + UserName + "] " + inputLine);
			}
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			server.removeClient(this);
			server.sendMessageAll("#" + UserName + " ���� �����̽��ϴ�.");
			System.out.println("Ŭ���̾�Ʈ \n" + socket + "\n���� ������ ������ϴ�...");
		}
	}

}
