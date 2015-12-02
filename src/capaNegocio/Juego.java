package capaNegocio;

import java.util.ArrayList;

import entidades.*;

public class Juego {
	private static final int COLOR_BLANCO = 0;
	private static final int COLOR_NEGRO = 1;
	

	private static ArrayList<Pieza> tablero;
	private int turno;
	private int nroJuego;
	private int jugador1;
	private int jugador2;
	
	public Juego() {
		// TODO Auto-generated constructor stub
	}

	public Juego(int nroJuego, int jugador1, int jugador2){
		this.turno=COLOR_BLANCO;
		this.nroJuego=nroJuego;
		this.jugador1=jugador1;
		this.jugador2=jugador2;
	}

	public void setTurno(int turno) {
		// TODO Auto-generated method stub
		this.turno=turno;
	}

	public void cambiarTurno(){
		if(turno==COLOR_BLANCO){
			turno=COLOR_NEGRO;
		}
		else{
			turno=COLOR_BLANCO;
		}
	}

	public ArrayList<Pieza> getPiezas(){
		return tablero;
	}
	
	public int getNroJuego(){
		return nroJuego;
	}
	
	public void setNroJuego(int nroJuego){
		this.nroJuego=nroJuego;
	}
	
	public String getStrTurno(){
		if (turno==COLOR_BLANCO){
			return "Blanco";
		}
		return "Negro";
	}

	public String getStrColumna(int columna){
		switch (columna){
		case 1: return "a";
		case 2: return "b";
		case 3: return "c";
		case 4: return "d";
		case 5: return "e";
		case 6: return "f";
		case 7: return "g";
		case 8: return "h";
		default: return "";
		}
	}

	public String getStrColor(int color){
		if (color==COLOR_BLANCO){
			return "Blanco";
		}
		return "Negro";
	}

	public int getTurno(){
		return turno;
	}
	
	public void iniciarJuego(){
		tablero = new ArrayList<Pieza>();
		tablero.add(new Rey(COLOR_BLANCO,1,5));
		tablero.add(new Dama(COLOR_BLANCO,1,4));
		tablero.add(new Torre(COLOR_BLANCO,1,1));
		tablero.add(new Torre(COLOR_BLANCO,1,8));
		tablero.add(new Alfil(COLOR_BLANCO,1,3));
		tablero.add(new Alfil(COLOR_BLANCO,1,6));
		tablero.add(new Caballo(COLOR_BLANCO,1,2));
		tablero.add(new Caballo(COLOR_BLANCO,1,7));
		for(int c=1;c<=8;c++){
			tablero.add(new Peon(COLOR_BLANCO,2,c));
		}
		tablero.add(new Rey(COLOR_NEGRO,8,4));
		tablero.add(new Dama(COLOR_NEGRO,8,5));
		tablero.add(new Torre(COLOR_NEGRO,8,1));
		tablero.add(new Torre(COLOR_NEGRO,8,8));
		tablero.add(new Alfil(COLOR_NEGRO,8,3));
		tablero.add(new Alfil(COLOR_NEGRO,8,6));
		tablero.add(new Caballo(COLOR_NEGRO,8,2));
		tablero.add(new Caballo(COLOR_NEGRO,8,7));
		for(int c=1;c<=8;c++){
			tablero.add(new Peon(COLOR_NEGRO,7,c));
		}
	}
	
	public void cargarJuego(ArrayList<Pieza> piezas){
		Juego.tablero=piezas;
	}
	
	public int confirmarPieza(int fromColumna,int fromFila,int toColumna,int toFila){
		int k=0;
		for(Pieza i: tablero){
			if (i.getFila()==fromFila && i.getColumna()==fromColumna){
				if(i.getColor()==turno){
					if(i.isMoveValid(toFila, toColumna)){
						for(Pieza j: tablero){
							if (j.getColumna()==toColumna&&j.getFila()==toFila){
								if(i.getColor()==j.getColor()){
									return 0;
								}
								if(eliminarPieza(k)){
									return 2;
								}
								break;
							}
							k++;
						}
						i.setColumna(toColumna);
						i.setFila(toFila);
						cambiarTurno();
						return 1;
					};
					break;
				}
			}
		}
		return 0;
	}
	
	public String confirmarPiezas(){
		String r="";
		for (Pieza i : tablero){
				r=r+i.getNombrePieza()+" "+getStrColor(i.getColor())+": "+getStrColumna(i.getColumna())+Integer.toString(i.getFila())+"<br>";
		}
		return r;
	}
	
	public String confirmarPiezas(int color){
		String r="";
		for (Pieza i : tablero){
			if(color==i.getColor()){
				r=r+i.getNombrePieza()+" "+getStrColor(i.getColor())+": "+getStrColumna(i.getColumna())+Integer.toString(i.getFila())+"<br>";
			}
		}
		return r;
	}
	

	public boolean confirmarMovimiento(Pieza pieza, int toFila, int toColumna){
		if (pieza.isMoveValid(toFila, toColumna)){
			return true;
		}
		return false;
	}
	
	public boolean eliminarPieza(int pieza){
		boolean r = false;
		if(tablero.get(pieza).getNroPieza()==1){
			r = true;
		};
		tablero.remove(pieza);
		return r;
	}
}
