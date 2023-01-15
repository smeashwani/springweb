package springweb.utils;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<Reservation> cvt(List<ReservationEntity> findAll) {
		return findAll.stream().map(item -> {
			Reservation res = new Reservation();
			BeanUtils.copyProperties(item,res);
		return res;
		}).collect(Collectors.toList());
	}

}
