package fr.usmb.m2isc.javaee.comptes.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Track implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String location;
	private Status status;

	@ManyToOne
	@JoinColumn(nullable=false)
	private Parcel parcel;

	public Track() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Track{" +
				"id=" + id +
				", date=" + date +
				", location='" + location + '\'' +
				", status=" + status +
				'}';
	}
}
