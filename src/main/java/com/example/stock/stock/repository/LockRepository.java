package com.example.stock.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.stock.stock.domain.Stock;

public interface LockRepository extends JpaRepository<Stock, Long> {

	@Query(value = "select get_lock(:key, 3000)", nativeQuery = true)
	void getLock(@Param("key") String key);

	@Query(value = "select release_lock(:key)", nativeQuery = true)
	void releaseLock(@Param("key") String key);
}
