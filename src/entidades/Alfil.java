package entidades;

import java.lang.Math;

public class Alfil extends Pieza {
	
	private static final String nombrePieza = "Alfil";
	private static final int nroPieza=4;
	
	public Alfil(int color, int fila, int columna) {
		super(color, fila, columna);
		// TODO Auto-generated constructor stub
	}

	public String getNombrePieza(){
		return nombrePieza;
	}
	
	public int getNroPieza() {
		return nroPieza;
	}
	
	public boolean isMoveValid(int toFila, int toColumna){
		if(Math.abs(fila-toFila)==Math.abs(columna-toColumna)){
			return true;
		}
		return false;
	}

}
