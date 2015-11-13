package entidades;

public class Torre extends Pieza {

	private static final String nombrePieza = "Torre";
	private static final int nroPieza=3;
	
	public Torre(int color, int fila, int columna) {
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
		boolean valid=false;
		if(fila==toFila||columna==toColumna){
			valid=true;
		}
		return valid;
	}

}
