package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Parcel;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class ParcelBean implements ParcelOperation {

	@PersistenceContext
	private EntityManager em;
	
	public ParcelBean() {
	}
	
	@Override
	public Parcel createParcel(Parcel parcel) {
		em.persist(parcel);
		return parcel;
	}
	
	@Override
	public Parcel getParcel(int id) {
		return em.find(Parcel.class, id);
	}

	@Override
	public List<Parcel> getAllParcel() {
		Query req = em.createNamedQuery("all");
		return req.getResultList();
	}

	@Override
	public void updateParcel(Parcel parcel){
		em.merge(parcel);
	}

	@Override
	public void delivering(Parcel parcel){
		parcel.setDelivered(true);
		em.merge(parcel);

	}


}
