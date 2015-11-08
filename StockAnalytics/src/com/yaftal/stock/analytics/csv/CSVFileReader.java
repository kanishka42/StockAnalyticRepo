/**
 * 
 */
package com.yaftal.stock.analytics.csv;

import java.io.Reader;
import java.time.LocalDate;
import java.util.List;

import com.yaftal.stock.analytics.models.Price;

/**
 * @author kanishka
 *
 */
public interface CSVFileReader {
	
	
	public List<Price> getPriceList();
	
	public List<Price> readCsvFileFromLocal(String file);
	
	public List<Price> readCsvFileFromInternet(LocalDate startDate, LocalDate endDate, String stockSymbole);

}
