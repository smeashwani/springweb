package springweb.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springweb.entity.ReservationEntity;

@Repository
public class ReservationRepo {
	
	@Autowired
	SessionFactory session;

	public ReservationEntity save(ReservationEntity res) {
		Session sess = session.openSession();
		Transaction tx = sess.beginTransaction();
		sess.persist(res);
		tx.commit();
		return res;
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
	public List<ReservationEntity> findAll(){
	return session.openSession().createQuery("From ReservationEntity",ReservationEntity.class).list();
	}
}
