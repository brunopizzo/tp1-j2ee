package fr.usmb.javaee;

import fr.usmb.m2isc.javaee.comptes.ejb.ParcelOperation;
import fr.usmb.m2isc.javaee.comptes.ejb.TrackOperation;
import fr.usmb.m2isc.javaee.comptes.jpa.Parcel;
import fr.usmb.m2isc.javaee.comptes.jpa.Status;
import fr.usmb.m2isc.javaee.comptes.jpa.Track;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


/**
 * Servlet utilisee pour transferer de l'argent d'un compte vers un autre compte.
 */
@WebServlet(value = "/postTrack", name ="postTrack" )
public class PostTrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParcelOperation ejbParcel;

	@EJB
	private TrackOperation ejbTrack;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTrackServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/showParcel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date date = new Date();

		int id = Integer.parseInt(request.getParameter("id"));
		String location = request.getParameter("location");
		Status status = Status.valueOf(request.getParameter("status"));
		Track track = new Track();
		track.setDate(date);
		track.setLocation(location);
		track.setParcel(ejbParcel.getParcel(id));
		track.setStatus(status);
		track = ejbTrack.createTrack(track);
		Parcel parcel = ejbParcel.getParcel(id);
		parcel.getTracks().add(track);
		ejbParcel.updateParcel(parcel);

        request.setAttribute("parcel", parcel);

        //adding possible states
        request.setAttribute("states", Status.values());

		doGet(request,response);





	}


}
