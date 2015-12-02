package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customException.NoGameFoundException;
import capaNegocio.CapaNegocio;

/**
 * Servlet implementation class LoadGameServlet
 */
@WebServlet("/LoadGameServlet")
public class LoadGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CapaNegocio capaNegocio = new CapaNegocio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{

			request.getSession().invalidate();

			
			HttpSession session=request.getSession();
			
			capaNegocio.cargarJuego(request.getParameter("nrojuego"));
			int jugadores[] = capaNegocio.cargarJugadores(request.getParameter("nrojuego"));
			session.setAttribute("jugador1",Integer.toString(jugadores[0]));
			session.setAttribute("jugador2",Integer.toString(jugadores[1]));
			session.setAttribute("nrojuego",capaNegocio.getNroJuego());
			session.setAttribute("turno", capaNegocio.getTurno());
			session.setAttribute("piezasblancas", capaNegocio.confirmarPiezas(0));
			session.setAttribute("piezasnegras", capaNegocio.confirmarPiezas(1));
			session.setAttribute("mov","");
			session.setAttribute("capanegocio", capaNegocio);
			
			request.getRequestDispatcher("chess.jsp").forward(request, response);
		}
		catch (NumberFormatException e){
			request.getSession().invalidate();
			request.setAttribute("msgerror", "El juego seleccionado no es valido");
			request.getRequestDispatcher("loadGame.jsp").forward(request, response);
		} 
		catch (NoGameFoundException e) {
			request.getSession().invalidate();
			request.setAttribute("msgerror", "No se encuentra el juego que usted busca");
			request.getRequestDispatcher("loadGame.jsp").forward(request, response);
		}
		catch(Exception e){
			request.getSession().invalidate();
			response.sendRedirect("errorpage.html");
		}
	}

}
