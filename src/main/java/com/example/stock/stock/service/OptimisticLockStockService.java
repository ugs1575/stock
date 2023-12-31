package com.example.stock.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stock.stock.domain.Stock;
import com.example.stock.stock.repository.StockRepository;

@Service
public class OptimisticLockStockService {

	private final StockRepository stockRepository;

	public OptimisticLockStockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Transactional
	public void decrease(Long id, Long quantity) {
		Stock stock = stockRepository.findByIdWithOptimisticLock(id);

		stock.decrease(quantity);
		stockRepository.save(stock);
	}
}
