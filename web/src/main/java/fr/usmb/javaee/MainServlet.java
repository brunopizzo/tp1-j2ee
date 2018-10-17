package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ParcelOperation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet utilisee pour transferer de l'argent d'un compte vers un autre compte.
 */
@WebServlet(value = "/home", name ="index" )
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParcelOperation ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setAttribute("parcels", ejb.getAllParcel());
		System.out.println(ejb.getAllParcel().toString());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}




}
