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
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�.");
		while (true) {
			try {
				serviceSocket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�.");
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
