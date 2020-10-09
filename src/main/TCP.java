package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCP extends Thread{
	
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private Observer observer;
	
	private static TCP tcp;
	
	private TCP() {
	
	}
	public static TCP instance() {
		if(tcp==null) {
			tcp=new TCP();
			tcp.start();
		}
		
		return tcp;
	}
	
	public void run() {
		initServer();
	}
	
	public void setObservador(Observer observador) {
		this.observer=observador;
	}
	
public void initServer() {
		
		new Thread(
				
				()->{
					
				try {
					//1.Esperar una conexion
					ServerSocket server = new ServerSocket(5000);
					System.out.println("Esperando conexion");
					socket = server.accept();
					
					//3.Cliente y Server Conectados
					System.out.println("Cliente conectado");
					
					InputStream is = socket.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					reader = new BufferedReader(isr);
					
					OutputStream os = socket.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					writer = new BufferedWriter(osw);
					
					
					while(true) {
						System.out.println("Recibiendo");
						String datos = reader.readLine();
						System.out.println(datos);
						observer.mensajeRecibido(datos);
						
					}
					
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
				).start();
	}
	
	public void sendMessage(String msg) {
		
		new Thread(
				()->{
				
					try {
						
						writer.write(msg+"\n");
						writer.flush();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				).start();
		
	}
}
