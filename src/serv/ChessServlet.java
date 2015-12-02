package serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import capaNegocio.CapaNegocio;

/**
 * Servlet implementation class ChessServlet
 */
@WebServlet("/ChessServlet")
public class ChessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChessServlet() {
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
			//System.out.println(request.getParameter("submitGame"));
			String mov;
			HttpSession session = request.getSession();
			String nroJuego = (String) session.getAttribute("nrojuego");
			CapaNegocio capaNegocio = (CapaNegocio) session.getAttribute("capanegocio");
			String op = request.getParameter("submitGame");
			if(op.equals("Mover")){
				String cd= (String)request.getParameter("columnadesde");
				String fd= (String)request.getParameter("filadesde");
				String ch= (String)request.getParameter("columnahasta");
				String fh= (String)request.getParameter("filahasta");

				mov = capaNegocio.movimiento(cd, fd, ch, fh);
				if(!capaNegocio.juegoIniciado()){
					session.invalidate();
					request.setAttribute("mov", mov);
					request.getRequestDispatcher("finDelJuego.jsp").forward(request, response);
				}
				session.setAttribute("mov",mov);
				session.setAttribute("turno", capaNegocio.getTurno());
				session.setAttribute("piezasblancas", capaNegocio.confirmarPiezas(0));
				session.setAttribute("piezasnegras", capaNegocio.confirmarPiezas(1));
			}
			else {
				capaNegocio.guardarJuego();
				mov = "Juego guardado";
				session.setAttribute("mov",mov);
			}
			
			request.getRequestDispatcher("chess.jsp").forward(request, response);
		}
		catch(Exception e){
			request.getSession().invalidate();
			response.sendRedirect("errorpage.html");
		}
	}

}
