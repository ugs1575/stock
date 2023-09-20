package com.example.stock.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.stock.stock.domain.Stock;
import com.example.stock.stock.repository.StockRepository;

@Service
public class StockService {

	private final StockRepository stockRepository;

	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	// @Transactional
	// public synchronized void decrease(Long id, Long quantity) {
	// 	// Stock 조회
	// 	// 재고를 감소시킨 뒤
	// 	// 갱신된 값을 저장하도록 하겠습니다.
	//
	// 	Stock stock = stockRepository.findById(id).orElseThrow();
	// 	stock.decrease(quantity);
	//
	// 	stockRepository.saveAndFlush(stock);
	// }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void decrease(Long id, Long quantity) {
		Stock stock = stockRepository.findById(id).orElseThrow();
		stock.decrease(quantity);

		stockRepository.saveAndFlush(stock);
	}


}
