package springweb.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springweb.entity.ReservationEntity;

@Repository
public class ReservationRepo {
	@Autowired
	HibernateTemplate template;

	public ReservationEntity save(ReservationEntity res) {
		template.save(res);
		return res;
	}
}
