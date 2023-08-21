package springweb.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springweb.entity.ReservationEntity;

@Repository
public class ReservationRepo {

	@Autowired
	   private SessionFactory sessionFactory;
	
	public ReservationEntity save(ReservationEntity res) {
		sessionFactory.getCurrentSession().persist(res);
		return res;
	}
}
