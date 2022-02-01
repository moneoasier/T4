package config;

import java.io.*;
import java.net.*;

public class HariZerbitzaria extends Thread {
//	BufferedReader sarreraFluxua;
//	PrintWriter irteeraFluxua;
	Socket socket = null;
	
	//String agurMezua = "agur";
	int hariZenbakia = -1;
	
	 BufferedInputStream bis;
     BufferedOutputStream bos;
	
	public HariZerbitzaria(int hariZenbakia, Socket s, BufferedInputStream bis, BufferedOutputStream bos)
	{
		this.hariZenbakia = hariZenbakia;
		this.socket = s;
		this.bis = bis;
	    this.bos = bos;
		
//		try {
//			// Sarrera eta irteerako fluxuak sortzen dira
//		//	sarreraFluxua = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//		//	irteeraFluxua = new PrintWriter(socket.getOutputStream());
//			
//			
////			 //Get input object, read file
////		        BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
////		        //Save to local
////		        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\prueba.json"));
//
//				
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public void run()
	{
//		String jasotakoTestua = "";
//		String bidaltzekoTestua = "";
//		System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + this.socket.toString());
//		while(0 != jasotakoTestua.trim().compareToIgnoreCase(agurMezua))
//		{
//			try {
//				jasotakoTestua = sarreraFluxua.readLine(); // Bezeroak bidalitakoa jaso
//				bidaltzekoTestua = jasotakoTestua.trim().toUpperCase();
//				irteeraFluxua.println(bidaltzekoTestua); // Jasotakoa maiuskulatara bihurtu eta bidali
//				irteeraFluxua.flush();
//				System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + bidaltzekoTestua);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		}
		
		 //Get input object, read file
       
//		try {
//			BufferedInputStream bis = new BufferedInputStream(this.socket.getInputStream());
//			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\prueba.json"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        //Save to local
       
		
        //Create byte array
        byte[] b = new byte[1024 * 8];
        //Read character array
       int len;
       
           try {
        	   
        	   while ((len = bis.read(b)) != -1) {
        		   bos.write(b, 0, len);
        	   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
//		
		System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikazioa bukatu da: " + this.socket.toString());
		
		try {
			//irteeraFluxua.close();
		//	sarreraFluxua.close();
			
			  //close resource
	        
	        bos.close();
	        bis.close();
			
		//	this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
