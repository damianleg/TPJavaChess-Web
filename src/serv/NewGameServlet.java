package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import capaNegocio.CapaNegocio;

/**
 * Servlet implementation class NewGameServlet
 */
@WebServlet("/NewGameServlet")
public class NewGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CapaNegocio capaNegocio = new CapaNegocio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGameServlet() {
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
		String jugador1 = ""; 
		String jugador2 = "";
		
		try{

			request.getSession().invalidate();			
			
			HttpSession session=request.getSession();
			
			jugador1 = request.getParameter("jugador1");
			jugador2 = request.getParameter("jugador2");
			System.out.println("1");
			capaNegocio.nuevoJuego(jugador1,jugador2);
			System.out.println("2");
			session.setAttribute("jugador1", jugador1);
			session.setAttribute("jugador2", jugador2);
			System.out.println("3");
			session.setAttribute("nrojuego",capaNegocio.getNroJuego());
			session.setAttribute("turno", capaNegocio.getTurno());
			System.out.println("5");
			session.setAttribute("piezasblancas", capaNegocio.confirmarPiezas(0));
			session.setAttribute("piezasnegras", capaNegocio.confirmarPiezas(1));
			session.setAttribute("mov","");
			System.out.println("6");
			session.setAttribute("capanegocio", capaNegocio);
			System.out.println("7");
			
			request.getRequestDispatcher("chess.jsp").forward(request, response);
			
			//response.sendRedirect("ChessServlet");
		}
		catch (NumberFormatException e){
			request.getSession().invalidate();
			request.setAttribute("msgerror", "El juego seleccionado no es valido");
			request.getRequestDispatcher("newGame.jsp").forward(request, response);
		}
		catch(Exception e){
			request.getSession().invalidate();
			response.sendRedirect("errorpage.html");
		}
	}

}
