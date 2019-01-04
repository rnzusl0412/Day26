package com.test04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	Vector<ServiceThread> Clients; // 클라이언트 객체를 저장하는곳

	public ChatServer() {
		Clients = new Vector<>();
	}

	public void addClient(ServiceThread st) { // 클라이언트가 접속하면 추가
		Clients.add(st);
	}

	public void removeClient(ServiceThread st) { // 클라이언트가 종료하면 삭제
		Clients.remove(st);
	}

	public void sendMessageAll(String str) { // 모든 클라이언트에게 받은 메세지를 출력
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
			System.err.println("연결 실패입니다.");
			System.exit(1);
		}
		System.out.println("서버 \n" + serverSocket + "\n에서 연결을 기다립니다.");
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
		System.out.println("서버를 종료합니다. ");
	}

}
