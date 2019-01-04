package com.test01;

import java.io.IOException;
import java.net.*;
import java.util.Calendar;

public class UDPclient {
	public static void main(String[] args) {
		UDPclient ut = new UDPclient();
		ut.connection();
	}

	@SuppressWarnings("resource")
	public void connection() {
		try {
			DatagramSocket dsocket = new DatagramSocket();
			String str = String.format("Local time: %tT", Calendar.getInstance()).trim();
			byte[] buff = str.getBytes();

			InetAddress addr;

			addr = InetAddress.getByName("192.168.0.190");

			DatagramPacket sendPacket = new DatagramPacket(buff, buff.length, addr, 8888);
			dsocket.send(sendPacket);
			System.out.println("Ŭ���̾�Ʈ ���� �޼��� Ȯ�� ��� : " + str);

		} catch (IOException e) {
			System.out.println(e);
		} finally {

		}

	}
}
