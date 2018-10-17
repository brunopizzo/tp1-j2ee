package fr.usmb.m2isc.javaee.comptes.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NamedQueries ({
	@NamedQuery(name="all", query="SELECT c FROM Parcel c"),
})
@Entity
public class Parcel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private double weight;
	private String source;
	private String destination;

	@OneToMany(
			targetEntity=Track.class,
			cascade=ALL,
			mappedBy="parcel",
			orphanRemoval=true,
			fetch = FetchType.EAGER)
	private List<Track> tracks = new ArrayList();
	private boolean delivered;

	
	public Parcel() {
	}


	public Parcel(int id, double weight) {
		super();
		this.id = id;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		return "Parcel{" +
				"id=" + id +
				", weight=" + weight +
				", source='" + source + '\'' +
				", destination='" + destination + '\'' +
				", tracks=" + tracks +
				", delivered=" + delivered +
				'}';
	}
}
