package main;

import processing.core.PApplet;

public class Bolita {
	
	PApplet app;
	int posX;
	int posY;
	String nombre="";
	int velocidad=5;
	int R;
	int G;
	int B;
	

	public Bolita(PApplet app, int posX, int posY) {
		this.posX= posX;
		this.posY= posY;
		this.app= app;
		R=34;
		G=113;
		B=179;
	}
	
	public void pintar() {
		app.fill(R,G,B);
		app.ellipse(posX,posY,55,55);
		app.text(nombre,posX,posY-40);
		
		
	}
	
	public void mover(String direccion) {
		
		switch(direccion) {
		case "arriba": 
			posY-=velocidad;
			break;
			
		case "abajo":
			posY+=velocidad;
			break;
		
		case "izquierda":
			posX-=velocidad;
			break;
			
		case "derecha":
			posX+=velocidad;
			break;
		
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
