package main;

public class Movimiento {
	
	private String tipo="movimiento";
	private String direccion;
	

	
	
	public Movimiento(String direccion) {
		this.direccion=direccion;
		
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
