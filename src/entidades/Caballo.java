package entidades;

import java.lang.Math;

public class Caballo extends Pieza {
	
	private static final String nombrePieza = "Caballo";
	private static final int nroPieza=5;
	
	public Caballo(int color, int fila, int columna) {
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
		if((Math.abs(fila-toFila)==2&&Math.abs(columna-toColumna)==1)
		&&(Math.abs(fila-toFila)==1&&Math.abs(columna-toColumna)==2)){
			return true;
		}
		return false;
	}
	
}
