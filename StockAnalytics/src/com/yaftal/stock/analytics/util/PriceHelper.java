/**
 * 
 */
package com.yaftal.stock.analytics.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.yaftal.stock.analytics.models.Price;

/**
 * @author kanishka
 *
 */
public class PriceHelper {
	
	/**
	 * Default Constructor
	 */
	public PriceHelper() {}
	
	
	/**
	 * 
	 * @param from
	 * @param to
	 * @param priceList
	 * @return
	 */
	public static List<Price> filterByDateRange(LocalDate from, LocalDate to, List<Price> priceList){
		
		List<Price> retPriceList = null;
		sortByDate(priceList);
		retPriceList = new ArrayList<Price>();
		
		for(Price p : priceList){
			if((p.getStockDate().isAfter(from) && p.getStockDate().isBefore(to)) 
					|| (p.getStockDate().isEqual(from) || p.getStockDate().isEqual(to))){
				retPriceList.add(p);
			}
		}
		
		return retPriceList;
	}
	
	// Step 2. find the highest price for step 1 list
	// Step 3. find the lowest price for step 1 list
	
	/**
	 * Find highest price by high price
	 * @param priceList
	 * @return
	 */
	public static Price findHighestPrice(List<Price> priceList){
		
		// first sort it
		sortByHighPrice(priceList);
		
		Price price = priceList.get((priceList.size()-1));
		
		return price;
	}
	
	/**
	 * Find lowest price by low price
	 * @param priceList
	 * @return
	 */
	public static Price findLowestPrice(List<Price> priceList){

		// first sort it
		sortByLowPrice(priceList);

		Price price = priceList.get(0);

		return price;
	}
	
	/**
	 * 
	 * @param priceList
	 */
	public static void sortByHighPrice(List<Price> priceList) {
		// Lambda Expressions 
		// priceList.sort((Price p1, Price p2) -> p1.getHighPrice().compareTo(p2.getHighPrice()));

		// Lambda Expressions 
		priceList.sort((p1, p2) -> p1.getHighPrice().compareTo(p2.getHighPrice()));
	}
	
	/**
	 * 
	 * @param priceList
	 */
	public static void sortByLowPrice(List<Price> priceList) {
		// Lambda Expressions 
		priceList.sort((p1, p2) -> p1.getLowPrice().compareTo(p2.getLowPrice()));
		
		
	}

	/**
	 * multiple_sort
	 * @param priceList
	 */
	public static void sortByHighPriceThenByLowPrice(List<Price> priceList) {
		
		Comparator<Price> byHighPrice = (p1, p2) -> p1.getHighPrice().compareTo(p2.getHighPrice());
		
		Comparator<Price> byLowPrice = (p1, p2) -> p1.getLowPrice().compareTo(p2.getLowPrice());
		
		priceList.sort(byHighPrice.thenComparing(byLowPrice));
	}
	
	/**
	 * 
	 * @param priceList
	 */
	public static void sortByDate(List<Price> priceList){
		// Lambda Expressions 
		//priceList.sort(comparing(Price::getStockDate));
		priceList.sort((p1, p2)-> p1.getStockDate().compareTo(p2.getStockDate()));
	}
	
	/*public class PriceComparatorHighPrice implements Comparator<Price> {

		@Override
		public int compare(Price price1, Price price2) {
			return price1.getHighPrice().compareTo(price2.getHighPrice());
		}		
	}*/

}
