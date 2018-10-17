package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ParcelOperation;
import fr.usmb.m2isc.javaee.comptes.jpa.Status;

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
@WebServlet(value = "/delivering", name ="delivering" )
public class DeliveringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParcelOperation ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveringServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/showParcel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int id = Integer.parseInt(request.getParameter("id"));
		ejb.delivering(ejb.getParcel(id));

		request.setAttribute("parcel", ejb.getParcel(id));

		//adding possible states
		request.setAttribute("states", Status.values());

		doGet(request,response);
	}




}
