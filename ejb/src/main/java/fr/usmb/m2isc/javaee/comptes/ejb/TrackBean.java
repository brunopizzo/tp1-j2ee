package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Parcel;
import fr.usmb.m2isc.javaee.comptes.jpa.Track;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class TrackBean implements TrackOperation {

	@PersistenceContext
	private EntityManager em;

	public TrackBean() {
	}
	
	@Override
	public Track createTrack(Track track) {
		em.persist(track);
		return track;
	}
	


}
