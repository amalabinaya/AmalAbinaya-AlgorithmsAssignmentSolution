package com.stockers.model;

public class Stocks {
	private double stockPrice;
	private boolean hasIncreased;

	public Stocks(double stockPrice, boolean hasIncreased) {
		this.stockPrice = stockPrice;
		this.hasIncreased = hasIncreased;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public boolean isHasIncreased() {
		return hasIncreased;
	}
}
