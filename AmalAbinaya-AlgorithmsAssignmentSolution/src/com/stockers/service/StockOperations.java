package com.stockers.service;

import java.util.Arrays;
import java.util.Comparator;
import com.stockers.model.Stocks;

public class StockOperations {
	private final Stocks[] stocks;
	private IncreasingComparator increasingComparator;
	private DecreasingComparator decreasingComparator;

	static class IncreasingComparator implements Comparator<Stocks>{

		public int compare(Stocks o1, Stocks o2) {
			return (int) (o1.getStockPrice() - o2.getStockPrice());
		}
	}

	static class DecreasingComparator implements Comparator<Stocks>{


		public int compare(Stocks o1, Stocks o2) {
			return (int) (o2.getStockPrice() - o1.getStockPrice());
		}
	}

	public StockOperations(Stocks[] stocks) {
		this.stocks = stocks;
		this.increasingComparator = new IncreasingComparator();
		this.decreasingComparator = new DecreasingComparator();
	}

	public Stocks[] getStocksInCreasingOrder(){
		Stocks[] tempStock = stocks;
		Arrays.sort(tempStock,increasingComparator);

		return tempStock;
	}

	public Stocks[] getStocksInDecreasingOrder(){
		Stocks[] tempStock = stocks;
		Arrays.sort(tempStock,decreasingComparator);
		return tempStock;
	}

	public int numberOfCompaniesStockRose(){
		int num = 0;
		for (Stocks stock : stocks){
			if(stock.isHasIncreased())
				num++;
		}
		return num;
	}

	public int numOfCompaniesStockDecreased(){
		int num = 0;
		for (Stocks stock : stocks){
			if(!stock.isHasIncreased())
				num++;
		}
		return num;
	}

	public  boolean searchForAStock(Double stock){
		int result = searchStock(stock);
		return result != -1;
	}

	private int searchStock(Double stock){
		int start = 0;
		int end = stocks.length -1 ;
		while (end >= start){
			int mid = (start + end)/2;
			if(stocks[mid].getStockPrice() == stock)
				return mid;
			else if(stocks[mid].getStockPrice() < stock){
				start = mid + 1;
			}else{
				end = mid -1 ;
			}
		}
		return -1;
	}
}
