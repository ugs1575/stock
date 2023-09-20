package com.example.stock.stock.facade;

import org.springframework.stereotype.Component;

import com.example.stock.stock.service.OptimisticLockStockService;

@Component
public class OptimisticLockStockFacade {

	private final OptimisticLockStockService optimisticLockStockService;

	public OptimisticLockStockFacade(OptimisticLockStockService optimisticLockStockService) {
		this.optimisticLockStockService = optimisticLockStockService;
	}

	public void decrease(Long id, Long quantity) throws InterruptedException {
		//업데이트 실패 시 재시도 필요
		while (true) {
			try {
				optimisticLockStockService.decrease(id, quantity);

				break;
			} catch (Exception e) {
				Thread.sleep(50);
			}
		}
	}
}
