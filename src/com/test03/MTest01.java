package com.test03;

import java.net.*;
import javax.swing.JFrame;
import java.awt.*;

@SuppressWarnings("serial")
public class MTest01 extends JFrame {
	Image image;

	public MTest01() throws Exception {
		URL url = new URL("http://localhost:8080/rnzusl/Test01/11.jpg"); // 지정된 url의 이미지를 생성해서 툴을 이용하여 이미지를 리턴
		image = Toolkit.getDefaultToolkit().createImage(url);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 10, 10, this); // 이미지를 그린다.
	}

	public void go() {
		setSize(800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			new MTest01().go();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
