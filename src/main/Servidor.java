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

import processing.core.PApplet;

public class Servidor extends PApplet implements Observer{
	
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	Bolita bolita;
	private TCP tcp;
	
	

	public static void main(String[] args) {
		PApplet.main("main.Servidor");

		
	}
	
	public void settings() {
		size(500,500);
	}

	public void setup() {
		
		tcp=TCP.instance();
		tcp.setObservador(this);
		bolita=new Bolita(this,110,110);
	}
	
	public void draw() {
		background(0);
		bolita.pintar();
		
		
	}

	@Override
	public void mensajeRecibido(String mensaje) {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		if(mensaje.contains("usuario")) {
			
			Usuario u = g.fromJson(mensaje, Usuario.class);
			bolita.setNombre(u.getUsuario());
			
		}
		
		if(mensaje.contains("direccion")) {
			Movimiento movimiento= g.fromJson(mensaje, Movimiento.class);
			bolita.mover(movimiento.getDireccion());
		}
		
		if(mensaje.contains("R")) {
			Color color= g.fromJson(mensaje, Color.class);
			bolita.R=color.getR();
			bolita.G= color.getG();
			bolita.B= color.getB();
			
		}
		
	}
	

}
