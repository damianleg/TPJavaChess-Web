package entidades;

public class Dama extends Pieza {
	
	private static final String nombrePieza = "Dama";
	private static final int nroPieza=2;
	
	public Dama(int color, int fila, int columna) {
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
		if (fila==toFila||columna==toColumna||Math.abs(fila-toFila)==Math.abs(columna-toColumna)){
			return true;
		}
		return false;
	}

}
