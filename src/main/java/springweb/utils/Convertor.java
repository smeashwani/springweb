package springweb.utils;

import org.springframework.beans.BeanUtils;

import springweb.entity.ReservationEntity;
import springweb.model.Reservation;

public class Convertor {
	
	private Convertor() {
	}
	
	public static ReservationEntity cvt(Reservation res) {
		ReservationEntity entity = new ReservationEntity();
		BeanUtils.copyProperties(res,entity);
		return entity;
	}

}
