package com.techsofin.sdccpayment.repository;

import com.techsofin.sdccpayment.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    List<Collection> findByColectionDate(Date providedDate);
}
