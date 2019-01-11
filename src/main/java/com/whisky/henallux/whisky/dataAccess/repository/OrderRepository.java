package com.whisky.henallux.whisky.dataAccess.repository;

import com.whisky.henallux.whisky.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<OrderEntity,String> {
}
