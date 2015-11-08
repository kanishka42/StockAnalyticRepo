/**
 * 
 */
package com.yaftal.stock.analytics.testers;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.yaftal.stock.analytics.csv.CSVFileReader;
import com.yaftal.stock.analytics.csv.CSVYahooFileReader;
import com.yaftal.stock.analytics.models.Price;
import com.yaftal.stock.analytics.util.PriceHelper;

/**
 * @author kanishka
 *
 */
public class CGITester {
	
	public static final String CVS_DATA_FILE = "CGI_table.csv";
	
	CSVFileReader csvFileReader;
	private List<Price> cgiPriceList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// build a price list from the csv file
		csvFileReader = new CSVYahooFileReader();
		// cgiPriceList = csvFileReader.getPriceList(); // get the list of the prices
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRange() {

		CSVYahooFileReader csvYahooFileReader = new CSVYahooFileReader();
		//cgiPriceList = csvYahooFileReader.readCsvFileFromLocal("CGI_table.csv");		
		
		LocalDate fromDate = LocalDate.parse("2015-01-02"); // specify a start date
		LocalDate toDate = LocalDate.parse("2015-10-23"); // specify an end date

		cgiPriceList = csvYahooFileReader.readCsvFileFromInternet(fromDate, toDate, "BBD-B.TO");
		
		// filtered price list based on the date range
		List<Price> newPriceList = PriceHelper.filterByDateRange(fromDate, toDate, cgiPriceList);

		Price highestPrice = PriceHelper.findHighestPrice(newPriceList);

		Price lowestPrice = PriceHelper.findLowestPrice(newPriceList);

		System.out.println("Range: " + lowestPrice.getStockDate() + " : " + lowestPrice.getLowPrice());
		System.out.println("Range: " + highestPrice.getStockDate() + " : " + highestPrice.getHighPrice());
				
		assertArrayEquals("Testing the highest price failed. ", new BigDecimal[] {new BigDecimal("4.24")}, new BigDecimal[] {highestPrice.getHighPrice()});
		
		
	}

}
