/**
 * 
 */
package com.yaftal.stock.analytics.models;

import java.math.BigDecimal;
import java.time.*;
/**
 * @author kanishka
 *
 */
public class Price {
	
	
	private String companyName;
	
	private String stockSymbol; // Company stock symbol/ticker e.g. "GIB.A"
	
	private LocalDate stockDate; // stock date
	
	private BigDecimal openPrice;
	
	private BigDecimal highPrice;
	
	private BigDecimal lowPrice;
	
	private BigDecimal closePrice;
	
	private BigDecimal volume;
	
	private BigDecimal adjClose; // Adjusted Close Price
	
	private BigDecimal tradeVolume;
	
	private int numberOfTrades;
	
	private BigDecimal priceChange;
	
	private BigDecimal priceChangePercent;
	
	
	/**
	 * Default Constructor
	 */
	public Price(){
		
	}


	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}


	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	/**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}


	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}


	/**
	 * @return the stockDate
	 */
	public LocalDate getStockDate() {
		return stockDate;
	}


	/**
	 * @param stockDate the stockDate to set
	 */
	public void setStockDate(LocalDate stockDate) {
		this.stockDate = stockDate;
	}


	/**
	 * @return the openPrice
	 */
	public BigDecimal getOpenPrice() {
		return openPrice;
	}


	/**
	 * @param openPrice the openPrice to set
	 */
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}


	/**
	 * @return the highPrice
	 */
	public BigDecimal getHighPrice() {
		return highPrice;
	}


	/**
	 * @param highPrice the highPrice to set
	 */
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}


	/**
	 * @return the lowPrice
	 */
	public BigDecimal getLowPrice() {
		return lowPrice;
	}


	/**
	 * @param lowPrice the lowPrice to set
	 */
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}


	/**
	 * @return the closePrice
	 */
	public BigDecimal getClosePrice() {
		return closePrice;
	}


	/**
	 * @param closePrice the closePrice to set
	 */
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}


	/**
	 * @return the volume
	 */
	public BigDecimal getVolume() {
		return volume;
	}


	/**
	 * @param volume the volume to set
	 */
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}


	/**
	 * @return the adjClose
	 */
	public BigDecimal getAdjClose() {
		return adjClose;
	}


	/**
	 * @param adjClose the adjClose to set
	 */
	public void setAdjClose(BigDecimal adjClose) {
		this.adjClose = adjClose;
	}


	/**
	 * @return the tradeVolume
	 */
	public BigDecimal getTradeVolume() {
		return tradeVolume;
	}


	/**
	 * @param tradeVolume the tradeVolume to set
	 */
	public void setTradeVolume(BigDecimal tradeVolume) {
		this.tradeVolume = tradeVolume;
	}


	/**
	 * @return the numberOfTrades
	 */
	public int getNumberOfTrades() {
		return numberOfTrades;
	}


	/**
	 * @param numberOfTrades the numberOfTrades to set
	 */
	public void setNumberOfTrades(int numberOfTrades) {
		this.numberOfTrades = numberOfTrades;
	}


	/**
	 * @return the priceChange
	 */
	public BigDecimal getPriceChange() {
		return priceChange;
	}


	/**
	 * @param priceChange the priceChange to set
	 */
	public void setPriceChange(BigDecimal priceChange) {
		this.priceChange = priceChange;
	}


	/**
	 * @return the priceChangePercent
	 */
	public BigDecimal getPriceChangePercent() {
		return priceChangePercent;
	}


	/**
	 * @param priceChangePercent the priceChangePercent to set
	 */
	public void setPriceChangePercent(BigDecimal priceChangePercent) {
		this.priceChangePercent = priceChangePercent;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Price [companyName=" + companyName + ", stockSymbol=" + stockSymbol + ", stockDate=" + stockDate
				+ ", openPrice=" + openPrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", closePrice="
				+ closePrice + ", volume=" + volume + ", adjClose=" + adjClose + ", tradeVolume=" + tradeVolume
				+ ", numberOfTrades=" + numberOfTrades + ", priceChange=" + priceChange + ", priceChangePercent="
				+ priceChangePercent + "]";
	}
}
