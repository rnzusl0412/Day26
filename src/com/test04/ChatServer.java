package com.test04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	Vector<ServiceThread> Clients; // Ŭ���̾�Ʈ ��ü�� �����ϴ°�

	public ChatServer() {
		Clients = new Vector<>();
	}

	public void addClient(ServiceThread st) { // Ŭ���̾�Ʈ�� �����ϸ� �߰�
		Clients.add(st);
	}

	public void removeClient(ServiceThread st) { // Ŭ���̾�Ʈ�� �����ϸ� ����
		Clients.remove(st);
	}

	public void sendMessageAll(String str) { // ��� Ŭ���̾�Ʈ���� ���� �޼����� ���
		try {
			for (ServiceThread st : Clients) {
				st.sendMessage(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServer server;
		ServerSocket serverSocket = null;
		int port = 9999;
		server = new ChatServer();
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("���� �����Դϴ�.");
			System.exit(1);
		}
		System.out.println("���� \n" + serverSocket + "\n���� ������ ��ٸ��ϴ�.");
		try {
			while (true) {
				Socket serviceSocket = serverSocket.accept();
				ServiceThread thread = new ServiceThread(server, serviceSocket);
				thread.start();
				server.addClient(thread);
			}
		} catch (Exception e) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("������ �����մϴ�. ");
	}

}
