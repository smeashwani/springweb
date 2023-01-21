package springweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springweb.entity.PaymentEntity;
import springweb.entity.ReservationEntity;
import springweb.model.Reservation;
import springweb.repo.PaymentRepo;
import springweb.repo.ReservationRepo;
import springweb.utils.Convertor;

@Service
@Transactional
public class ReservationService {
	
	@Autowired
	private ReservationRepo reservationDao;
	
	@Autowired
	private PaymentRepo paymentDao;

	@Transactional
	public Reservation save(Reservation res) {
		ReservationEntity entity = reservationDao.save(Convertor.cvt(res));
		PaymentEntity pEntity = new PaymentEntity();
		pEntity.setResId(entity.getId());
		pEntity.setAmount(res.getAmount());
		paymentDao.save(pEntity);
		//int i =10/0;
//		if(res != null) {
//			throw new RuntimeException();
//		}
		System.out.println("Saved in DB");
		return res;
	}
	
	public List<Reservation> findAll() {
		List<PaymentEntity> payLst = paymentDao.findAll();
		List<Reservation> cvt = Convertor.cvt(reservationDao.findAll());
		cvt.stream().forEach(item -> {
			int id = item.getId();
			Optional<PaymentEntity> paymentFind = payLst.stream().filter(paymentItem -> paymentItem.getResId() == id).findAny();
			if(paymentFind.isPresent()) {
				PaymentEntity payment = paymentFind.get();
				item.setAmount(payment.getAmount());
			}
		});
		
		return cvt;
	}
	
	
	public List<ReservationEntity> findByFirstName(String firstName){
		return reservationDao.findByFirstName(firstName);
	}
}
