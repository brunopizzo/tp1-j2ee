package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Parcel;

import java.util.List;

public interface ParcelOperation {

	Parcel createParcel(Parcel parcel);

	Parcel getParcel(int number);

	List<Parcel> getAllParcel();

	void updateParcel(Parcel parcel);

	void delivering(Parcel parcel);


}