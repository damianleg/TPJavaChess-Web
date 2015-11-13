package entidades;

public class Peon extends Pieza {
	
	private static final String nombrePieza = "Peon";
	private static final int nroPieza=6;
	private int mov;
	
	public Peon(int color, int fila, int columna) {
		super(color, fila, columna);
		// TODO Auto-generated constructor stub
		if (color==0){
			mov=1;
		}
		else{
			mov=-1;
		}
	}
	
	public String getNombrePieza(){
		return nombrePieza;
	}
	
	public int getNroPieza() {
		return nroPieza;
	}
	
	public boolean isMoveValid(int toFila, int toColumna){
		if (fila==2||fila==7){
			if (fila+(mov*2)==toFila&&columna==toColumna){
				return true;
			}
		}
		if (fila+(mov*1)==toFila&&columna==toColumna){
			return true;
		}
		return false;
	}
	
	public boolean isMoveValidPeon(int toFila, int toColumna){
		if (fila+(mov*1)==toFila&&Math.abs(columna-toColumna)==1){
			return true;
		}
		return false;
	}
	
}
