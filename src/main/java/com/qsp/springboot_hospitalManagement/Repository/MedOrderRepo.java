package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer> {

}
