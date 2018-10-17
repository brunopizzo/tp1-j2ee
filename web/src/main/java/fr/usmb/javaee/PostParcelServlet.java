package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ParcelOperation;
import fr.usmb.m2isc.javaee.comptes.jpa.Parcel;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet utilisee pour transferer de l'argent d'un compte vers un autre compte.
 */
@WebServlet(value = "/postParcel", name ="postParcel" )
public class PostParcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParcelOperation ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostParcelServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long weight = Long.parseLong(request.getParameter("weight"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		Parcel parcel = new Parcel();
		parcel.setWeight(weight);
		parcel.setSource(source);
		parcel.setDestination(destination);
		parcel = ejb.createParcel(parcel);


		PrintWriter out = response.getWriter();
		out.println( "<html><head></head><body><br><p>Parcel created :" + parcel.toString() +"</p><br/><a href=\"createParcel.html\">back</a></body></html>");

	}


}
