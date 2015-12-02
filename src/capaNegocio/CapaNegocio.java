package capaNegocio;

import customException.*;
import capaDatos.CapaDatos;

public class CapaNegocio {
	
	private CapaDatos capaDatos = new CapaDatos();
	private Juego juego=null;
	
	public String nuevoJuego(String StrJugador1,String StrJugador2) throws NumberFormatException {
		int nroJuego;
		int jugador1;
		int jugador2;
		try {
			jugador1 = Integer.parseInt(StrJugador1);
			jugador2 = Integer.parseInt(StrJugador2);
			nroJuego=capaDatos.nuevoJuego(jugador1,jugador2);
			juego = new Juego(nroJuego,jugador1,jugador2);
			juego.iniciarJuego();
			guardarJuego();
			return Integer.toString(nroJuego);
		}
		catch (NumberFormatException e){
			throw e;
		}
	}
	
	public int[] cargarJugadores(String nroJuego) throws NumberFormatException,NoGameFoundException{
		try{
			return capaDatos.cargarJugadores(Integer.parseInt(nroJuego));
		}
		catch (NumberFormatException e){
			throw e;
		}
		catch (NoGameFoundException e){
			throw e;
		}
	}
	
	public String cargarJuego(String nroJuego){
		juego = new Juego();
		juego.setNroJuego(Integer.parseInt(nroJuego));
		juego.setTurno(capaDatos.getTurno(Integer.parseInt(nroJuego)));
		juego.cargarJuego(capaDatos.cargarJuego(Integer.parseInt(nroJuego)));
		return "Juego cargado; Turno "+juego.getStrTurno();
	}
	
	public void guardarJuego() throws NullPointerException{
		if (juego==null){
			throw new NullPointerException("No hay juego iniciado");
		}
		capaDatos.actualizarTurno(juego.getTurno(), juego.getNroJuego());
		capaDatos.eliminarJuego(juego.getNroJuego());
		capaDatos.guardarJuego(juego.getNroJuego(), juego.getPiezas());
	}

	public String movimiento(String strFromColumna, String strFromFila, String strToColumna, String strToFila) throws NullPointerException,NumberFormatException{
		try{
			if (juego==null){
				throw new NullPointerException("No hay juego iniciado");
			}			
			int fromColumna = (int) strFromColumna.charAt(0)-96;
			int fromFila = Integer.parseInt(strFromFila);			
			int toColumna = (int) strFromColumna.charAt(0)-96;
			int toFila = Integer.parseInt(strToFila);
			if (confirmarFilaColumna(toFila)&&confirmarFilaColumna(toColumna)&&confirmarFilaColumna(fromFila)&&confirmarFilaColumna(fromColumna)){
				int num = juego.confirmarPieza(fromColumna, fromFila, toColumna, toFila);
				switch (num){
				case 1: return strFromColumna+strFromFila+" -> "+strToColumna+strToFila;
				case 2: 
					String r = "Rey capturado. Ganador jugador "+juego.getStrTurno();
					juego = null;
					return r;
				default: break;
				}
			}
			return "Movimiento no valido";	
		}
		catch (NumberFormatException e){
			throw e;
		}		
	}
	
	public String confirmarPiezas() throws NullPointerException{
		if (juego==null){
			throw new NullPointerException("No hay juego iniciado");
		}
		return juego.confirmarPiezas();
	}
	
	public String confirmarPiezas(int color) throws NullPointerException{
		if (juego==null){
			throw new NullPointerException("No hay juego iniciado");
		}
		return juego.confirmarPiezas(color);
	}
	
	public String getTurno(){
		return juego.getStrTurno();
	}
	
	public String getNroJuego(){
		return Integer.toString(juego.getNroJuego());
	}
	
	private boolean confirmarFilaColumna(int filaColumna){
		if(filaColumna>0&&filaColumna<9){
			return true;
		}
		return false;
	}
	
	public boolean juegoIniciado(){
		if(juego!=null){
			return true;
		}
		return false;
	}
}
