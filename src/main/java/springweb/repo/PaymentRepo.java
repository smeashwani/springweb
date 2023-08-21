package springweb.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import springweb.entity.PaymentEntity;

@Repository
public class PaymentRepo {
	
	@PersistenceContext
	EntityManager entityManager;

	public PaymentEntity save(PaymentEntity payment) {
		entityManager.persist(payment);
		return payment;
	}

	public List<PaymentEntity> findAll() {
		TypedQuery<PaymentEntity> query = entityManager.createQuery("From PaymentEntity",
				PaymentEntity.class);
		return query.getResultList();
	}
}
