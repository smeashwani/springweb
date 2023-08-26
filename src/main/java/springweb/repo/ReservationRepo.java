package springweb.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springweb.entity.ReservationEntity;

@Repository
public class ReservationRepo {

	@Autowired
	   private SessionFactory sessionFactory;
	
	public ReservationEntity save(ReservationEntity res) {
		Session sess = sessionFactory.getCurrentSession();
		Transaction tx = sess.beginTransaction();
			sess.persist(res);
		tx.commit();
		return res;
	}
}
