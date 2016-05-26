/**
 * 
 */
package uk.co.sainsburys.utils;

import java.math.BigDecimal;
import java.util.List;

import uk.co.sainsburys.entities.Product;

/**
 * Utility Class with various methods
 * regarding Product related calculations
 * 
 * @author Michail Vasilakopoulos
 * @version 0.1a May 12 2016
 *
 */
public class ProductCalculationsUtils {
	
	/**
	 * Gets a List of Product and calculates their Unit Price Sum
	 * 
	 * @param productList the Product List 
	 * @return BigDecimal the Unit Price Sum
	 */
	public static BigDecimal calculateProductListSum(List<Product> productList) {
		System.out.println("Calculating the products unit price sum...");
		BigDecimal sum = new BigDecimal(0.00);
		
		for (Product prod : productList) {
			sum = sum.add(prod.getUnit_price());
		}
		System.out.println("Products unit price sum calculated...");
		
		return sum;
	}

}
