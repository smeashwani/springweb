package springweb.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

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
