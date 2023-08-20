package springweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springweb.entity.ReservationEntity;
import springweb.model.Reservation;
import springweb.repo.ReservationRepo;
import springweb.utils.Convertor;

@Service
@Transactional
public class ReservationService {
	
	@Autowired
	private ReservationRepo dao;

	public Reservation save(Reservation res) {
		ReservationEntity entity = dao.save(Convertor.cvt(res));
		System.out.println("Saved in DB");
		return res;
	}
}
