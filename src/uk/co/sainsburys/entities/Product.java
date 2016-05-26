/**
 * 
 */
package uk.co.sainsburys.entities;

import java.math.BigDecimal;

/**
 * Represents a Sainsbury's Online Product with the required attributes
 * 
 * @author Mchail Vasilakopoulos
 * @version 0.1a May 12 2016
 *
 */
public class Product {

	private String title;
	private String size;
	private BigDecimal unit_price;
	private String description;

	/**
	 * @return the Product title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the Product title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the Product page size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the Product page size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the Product unit_price
	 */
	public BigDecimal getUnit_price() {
		return unit_price;
	}
	/**
	 * @param unit_price the Product unit_price to set
	 */
	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	/**
	 * @return the Product description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the Product description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
