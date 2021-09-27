package com.stockers.ui;

import com.stockers.model.Stocks;

interface UserInterface{

	Stocks[] buildStockInfo();
	void displayOptions();
	void displayStocks(Stocks[] stocks);

}