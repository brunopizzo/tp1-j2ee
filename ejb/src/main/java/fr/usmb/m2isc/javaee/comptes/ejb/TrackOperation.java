package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Parcel;
import fr.usmb.m2isc.javaee.comptes.jpa.Track;

import java.util.List;

public interface TrackOperation {

	Track createTrack(Track track);

}