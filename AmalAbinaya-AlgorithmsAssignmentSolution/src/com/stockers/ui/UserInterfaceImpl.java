package com.stockers.ui;

import com.stockers.model.Stocks;
import com.stockers.service.StockOperations;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {

	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		UserInterfaceImpl instance = new UserInterfaceImpl();
		Stocks[] stocksInfo = instance.buildStockInfo();
		Scanner sc=new Scanner(System.in);  
		StockOperations stockProcessor = new StockOperations(stocksInfo);
		int selectedOption = 0;
		do {
			instance.displayOptions();
			selectedOption = sc.nextInt();
			handleOptions(instance, stockProcessor, selectedOption);
		} while (selectedOption < 6);
		System.out.println("Exited Successfully");
	}


	private static void handleOptions(UserInterfaceImpl instance, StockOperations stockProcessor, int selectedOption) {
		double stockPrice=0.00;
		switch (selectedOption) {
		case 1: {
			instance.displayStocks(stockProcessor.getStocksInCreasingOrder());
			break;
		}

		case 2: {
			instance.displayStocks(stockProcessor.getStocksInDecreasingOrder());
			break;
		}

		case 3: {
			int count = stockProcessor.numberOfCompaniesStockRose();
			System.out.println(count);
			break;
		}

		case 4: {
			int count = stockProcessor.numOfCompaniesStockDecreased();
			System.out.println(String.valueOf(count));
			break;
		}

		case 5: {
			System.out.println("enter the key value");
			stockPrice = instance.scanner.nextDouble();
			boolean isPresent = stockProcessor.searchForAStock(stockPrice);
			String message = "Stock of value " + stockPrice;
			if (isPresent) {
				message += " is present";
			} else {
				message += " is not present";
			}
			System.out.println(message);
		}
		}
	}


	public Stocks[] buildStockInfo() {

		System.out.println("enter the no of companies");
		int numberOfCompanies = scanner.nextInt();
		Stocks[] stockArray = new Stocks[numberOfCompanies];
		for (int num = 0; num < numberOfCompanies; num++) {

			System.out.println("Enter current stock price of the company " + (num + 1));
			double price = scanner.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			boolean hasRaised = scanner.nextBoolean();

			stockArray[num] = new Stocks(price, hasRaised);
		}

		return stockArray;
	}


	public void displayOptions() {

		System.out.println("\n-----------------------------------------------\n"+
				"Enter the operation that you want to perform : \n"+
				"1.Display the companies stock prices in ascending order\n"+
				"2.Display the companies stock prices in descending order\n"+
				"3.Display the total no of companies for which stock prices rose today\n"+
				"4.Display the total no of companies for which stock prices declined today\n"+
				"5.Search a specific stock price\n"+
				"6.Exit\n"+
				"-----------------------------------------------");
	}

	public void displayStocks(Stocks[] stocks) {
		for (Stocks stock : stocks)
			System.out.println(stock.getStockPrice());
	}
}
