package springweb.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import springweb.entity.ReservationEntity;

@Repository
public class ReservationRepo {

	@PersistenceContext
	EntityManager entityManager;

	public ReservationEntity save(ReservationEntity res) {
		entityManager.persist(res);
		return res;
	}

	public List<ReservationEntity> findAll() {
		TypedQuery<ReservationEntity> query = entityManager.createQuery("From ReservationEntity",
				ReservationEntity.class);
		return query.getResultList();
	}
}
