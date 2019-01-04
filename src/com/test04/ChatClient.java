package com.test04;

import java.awt.Frame;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ChatClient extends Frame implements Runnable {

	Socket clientSocket = null;

	PrintWriter out = null;
	BufferedReader in = null;

	TextArea outputArea;
	TextField inputField;

	public ChatClient(String title) {
		super(title);

		setLayout(new BorderLayout());

		outputArea = new TextArea();
		outputArea.setEditable(false);

		add(outputArea, "Center");
		inputField = new TextField();
		add(inputField, "South");

		inputField.addActionListener(new InputListener());
	}

	public void addMessage(String msg) {
		outputArea.append(msg);
	}

	public void connect(String host, int port) {
		try {
			clientSocket = new Socket(host, port);

			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		} catch (Exception e) {
			System.err.println("입출력 에러입니다.");
			System.exit(1);
		}

	}

	public void disconnect() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
		}
	}

	public void run() {
		try {
			while (true) {
				addMessage(in.readLine() + "\n");
			}
		} catch (IOException e) {
			disconnect();
		}
	}

	public static void main(String[] args) {

		ChatClient mf = new ChatClient("자바 채팅 클라이언트");

		mf.pack();
		mf.setSize(500, 300);
		mf.setVisible(true);

		mf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		mf.connect("127.0.0.1", 9999);

		Thread thread = new Thread(mf);
		thread.start();
	}

	class InputListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String input = inputField.getText();
			inputField.setText("");
			try {
				out.println(input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}