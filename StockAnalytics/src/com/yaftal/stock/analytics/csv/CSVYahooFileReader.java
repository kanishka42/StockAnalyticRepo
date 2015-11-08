/**
 * 
 */
package com.yaftal.stock.analytics.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.yaftal.stock.analytics.models.Price;

/**
 * @author kanishka
 *
 */
public class CSVYahooFileReader implements CSVFileReader {
	
	// CSV file header
	private static final String[] FILE_HEADER_MAPPING = {"Date", "Open", "High", "Low", "Close", "Volume", "Adj Close"};
	
	private static final String PRICE_STOCK_DATE = "Date";
	private static final String PRICE_OPEN = "Open";
	private static final String PRICE_HIGH = "High";
	private static final String PRICE_LOW = "Low";
	private static final String PRICE_CLOSE = "Close";
	private static final String PRICE_VOLUME = "Volume";
	private static final String PRICE_ADJ_CLOSE = "Adj Close";
	
	List<Price> priceList = null;
	
	/**
	 * Default Constructor
	 */
	public CSVYahooFileReader() {}
	
	/**
	 * @return the priceList
	 */
	@Override
	public List<Price> getPriceList() {
		return priceList;
	}
	
	@Override
	public List<Price> readCsvFileFromLocal(String file) {
		
		// initialize FileReader object
		 try {
			FileReader fileReader = new FileReader(file);
			
			priceList = getPriceListFromYahooCsvFile(fileReader);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return priceList;
	}



	@Override
	public List<Price> readCsvFileFromInternet(LocalDate startDate, LocalDate endDate, String stockSymbole) {		
		
		String fileURL = buildHTTPYahooStockDataURL(startDate, endDate, stockSymbole);
		// fileURL = "http://real-chart.finance.yahoo.com/table.csv?s=BBD-B.TO&a=01&b=15&c=2014&d=10&e=16&f=2015&g=d&ignore=.csv"; // buildHTTPYahooStockDataURL();
		
		try {
			
			InputStream input = new URL(fileURL).openStream();
			
			Reader reader = new InputStreamReader(input);
			
			priceList = getPriceListFromYahooCsvFile(reader);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return priceList;
	}
	
	public List<Price> readLocalCsvFile(String fileName) {
		
		FileReader fileReader = null;
		
		CSVParser csvFileParser = null;
		
		// Create the CSVFormat object with the header mapping
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		
		try {
			// Create a new list of price to be filled by CSV file data
			priceList = new ArrayList<Price>();
			
			// initialize FileReader object
			fileReader = new FileReader(fileName);
			
			// initialize CSVParser object 
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			// Get a list of CSV file records
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			// Read the CSV file records starting from the second record to skip the header
			for (int i = 1; i < csvRecords.size(); i++) {
				
				CSVRecord record = csvRecords.get(i);
				
				// Create a new price object and fill its data
				Price price = new Price();
				
				price.setStockDate(LocalDate.parse(record.get(PRICE_STOCK_DATE), DateTimeFormatter.ISO_LOCAL_DATE));
				price.setOpenPrice(new BigDecimal(record.get(PRICE_OPEN)));
				price.setHighPrice(new BigDecimal(record.get(PRICE_HIGH)));
				price.setLowPrice(new BigDecimal(record.get(PRICE_LOW)));
				price.setClosePrice(new BigDecimal(record.get(PRICE_CLOSE)));
				price.setVolume(new BigDecimal(record.get(PRICE_VOLUME)));
				price.setAdjClose(new BigDecimal(record.get(PRICE_ADJ_CLOSE)));
				
				priceList.add(price);
			}			
			
		} catch (Exception e) {
			System.out.println("Error in CSVYahooFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/CSVYahooFileReader !!!");
				e.printStackTrace();
			}
		}
		
		return priceList;
	}
	
	
	/**
	 * 
	 * @param reader
	 * @return
	 */
	public List<Price> getPriceListFromYahooCsvFile(Reader reader) {
		
		CSVParser csvFileParser = null;
		
		// Create the CSVFormat object with the header mapping
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		
		try {
			// Create a new list of price to be filled by CSV file data
			priceList = new ArrayList<Price>();
			
			// initialize CSVParser object 
			csvFileParser = new CSVParser(reader, csvFileFormat);
			
			// Get a list of CSV file records
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			// Read the CSV file records starting from the second record to skip the header
			for (int i = 1; i < csvRecords.size(); i++) {
				
				CSVRecord record = csvRecords.get(i);
				
				priceList.add(mapCSVToPrice(record));
			}			
			
		} catch (Exception e) {
			System.out.println("Error in CSVYahooFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				csvFileParser.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/CSVYahooFileReader !!!");
				e.printStackTrace();
			}
		}
		
		return priceList;
	}


	
	
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	private Price mapCSVToPrice(CSVRecord record) {
		// Create a new price object and fill its data
		Price price = new Price();
		
		price.setStockDate(LocalDate.parse(record.get(PRICE_STOCK_DATE), DateTimeFormatter.ISO_LOCAL_DATE));
		price.setOpenPrice(new BigDecimal(record.get(PRICE_OPEN)));
		price.setHighPrice(new BigDecimal(record.get(PRICE_HIGH)));
		price.setLowPrice(new BigDecimal(record.get(PRICE_LOW)));
		price.setClosePrice(new BigDecimal(record.get(PRICE_CLOSE)));
		price.setVolume(new BigDecimal(record.get(PRICE_VOLUME)));
		price.setAdjClose(new BigDecimal(record.get(PRICE_ADJ_CLOSE)));
		
		return price;
	}
	
	private String buildHTTPYahooStockDataURL(LocalDate startDate, LocalDate endDate, String stockSymbole){ // GIB-A.TO
		
		// caution: month starts from 00 e.g. jan = 00, feb = 01, and dec = 11
		// the format is: month + day + year
		return "http://real-chart.finance.yahoo.com/table.csv?s=" + stockSymbole 
		+ "&a=" + (startDate.getMonthValue()-1)
		+ "&b=" + startDate.getDayOfMonth()
		+ "&c=" + startDate.getYear() 
		+ "&d=" + (endDate.getMonthValue()-1)
		+ "&e=" + endDate.getDayOfMonth()
		+ "&f=" + endDate.getYear()
		+ "&g=d&ignore=.csv";
	}
	
}
