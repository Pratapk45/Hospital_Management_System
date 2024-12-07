package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.MedItem;

public interface MedItemRepo extends JpaRepository<MedItem, Integer> {

}
