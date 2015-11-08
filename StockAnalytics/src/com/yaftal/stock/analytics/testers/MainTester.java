/**
 * 
 */
package com.yaftal.stock.analytics.testers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.yaftal.stock.analytics.csv.CSVFileReader;
import com.yaftal.stock.analytics.csv.CSVYahooFileReader;
import com.yaftal.stock.analytics.models.Price;
import com.yaftal.stock.analytics.util.PriceHelper;

/**
 * @author kanishka
 *
 */
public class MainTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Price> priceList = new ArrayList<Price>();
		
		Price p1 = new Price();
		p1.setHighPrice(new BigDecimal("5.99"));
		p1.setLowPrice(new BigDecimal("3.98"));
		
		Price p2 = new Price();
		p2.setHighPrice(new BigDecimal("6.99"));
		p2.setLowPrice(new BigDecimal("4.45"));
		
		Price p3 = new Price();
		p3.setHighPrice(new BigDecimal("6.99"));
		p3.setLowPrice(new BigDecimal("4.49"));
		
		Price p4 = new Price();
		p4.setHighPrice(new BigDecimal("4.99"));
		p4.setLowPrice(new BigDecimal("5.99"));
		
		
		priceList.add(p1);
		priceList.add(p2);
		priceList.add(p3);
		priceList.add(p4);
		
		PriceHelper.sortByHighPriceThenByLowPrice(priceList);
		
		//Price highestPrice = PriceHelper.findHighestPrice(priceList);
		
		//System.out.println("highestPrice: " + highestPrice.getHighPrice());
		
		CSVFileReader csvFileReader = new CSVYahooFileReader();
		List<Price> cgiPriceList = csvFileReader.getPriceList();
		
		LocalDate fromDate = LocalDate.parse("2014-01-02");
		LocalDate toDate = LocalDate.parse("2015-10-23");
		List<Price> newPriceList = PriceHelper.filterByDateRange(fromDate, toDate, cgiPriceList);
		
		//newPriceList.stream().forEach(p -> System.out.println(p));
		
		Price highestPrice = PriceHelper.findHighestPrice(newPriceList);
		
		Price lowestPrice = PriceHelper.findLowestPrice(newPriceList);
		
		System.out.println("Range: " + lowestPrice.getStockDate() + " : " + lowestPrice.getLowPrice());
		System.out.println("Range: " + highestPrice.getStockDate() + " : " + highestPrice.getHighPrice());
		
		System.out.println("Execution completed.");

	}
	
	public static Price findHighPriceByMonth(LocalDate dateCondition, List<Price> priceList) {
		
		Price retPrice = null;
		
		return retPrice;
	}
	
	

}
