package com.test01;

import java.io.IOException;
import java.net.*;
import java.util.Calendar;

public class UDPserver {
	public static void main(String[] args) {
		UDPserver ur = new UDPserver();
		ur.service();
	}

	@SuppressWarnings("resource")
	public void service() {
		try {
			Calendar cal = Calendar.getInstance();
			DatagramSocket dsocket;

			dsocket = new DatagramSocket(8888);

			byte[] buff = new byte[1024];
			DatagramPacket recvPacket = new DatagramPacket(buff, buff.length);
			dsocket.receive(recvPacket);

			String recvMsg = new String(recvPacket.getData());
			String s = String.format("받은 날짜 : %1$tm %1$te,%1$tY", cal);
			System.out.println(s + "  " + recvMsg.trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
