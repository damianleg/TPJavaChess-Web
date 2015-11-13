package entidades;

public abstract class Pieza {
	
	protected int color;
	protected int fila;
	protected int columna;
	
	public Pieza(int color, int fila, int columna){
		this.color = color;
		this.fila = fila;
		this.columna = columna;
	}
	
	public abstract String getNombrePieza();
	public abstract int getNroPieza();
	public abstract boolean isMoveValid(int toFila, int toColumna);
	
	public int getColor(){
		return color;
	}
	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
}
