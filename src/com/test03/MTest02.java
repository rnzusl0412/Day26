package com.test03;

import java.io.*;
import java.net.*;

public class MTest02 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/rnzusl/Test01/11.jpg");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while ((str = in.readLine()) != null) {
			System.out.println(str);
		}
		in.close();
	}
}
