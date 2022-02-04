package config;

import java.io.*;
import java.net.*;

public class HariZerbitzaria extends Thread {

	Socket socket = null;
	int hariZenbakia = -1;
	BufferedInputStream bis;
	BufferedOutputStream bos;

	public HariZerbitzaria(int hariZenbakia, Socket s, BufferedInputStream bis, BufferedOutputStream bos) {
		this.hariZenbakia = hariZenbakia;
		this.socket = s;
		this.bis = bis;
		this.bos = bos;

	}

	public void run() {

		// Create byte array
		byte[] b = new byte[1024 * 8];
		// Read character array
		int len;

		try {

			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikazioa bukatu da: "
				+ this.socket.toString());

		try {

			// close resource

			bos.close();
			bis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
