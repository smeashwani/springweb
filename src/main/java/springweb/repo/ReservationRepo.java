package springweb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springweb.entity.ReservationEntity;

@Repository
public interface ReservationRepo extends JpaRepository<ReservationEntity, Integer> {
 
	//@Query("select r from ReservationEntity r where r.lastName =  :firstName")
	List<ReservationEntity> findByFirstName(@Param("firstName") String firstName);
	
	//@Query("select r from ReservationEntity r where r.lastName =  ?1")
	//List<ReservationEntity> findByFirstName(String firstName);
}
