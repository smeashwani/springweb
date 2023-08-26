package springweb.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
