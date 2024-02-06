package com.hexaware.dao.service;

import com.hexaware.model.*;

public interface IAdoptable {
	void adopt();

	void Participants();

	void registerParticipant(Participants participants);

	void hostAdoptionEvent(AdoptionEvents adoptionEvents);
}
