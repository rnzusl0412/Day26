package com.test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Socket01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, UnknownHostException {
		Socket so = new Socket("192.168.0.190", 8910);
		System.out.println("connected to " + so.getInetAddress() + " on port " + so.getPort() + "from port "
				+ so.getLocalPort() + " of " + so.getLocalAddress());
		OutputStream out = so.getOutputStream();

		out.write('*');

		InputStream r = so.getInputStream();
		byte[] b = new byte[1024];
		r.read(b);

		String str = new String(b);
		System.out.println(str);
//		for (byte res : b) {
//			System.out.print((char) res);
//		}
		r.close();
		out.close();

	}
}
