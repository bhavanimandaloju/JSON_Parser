/**
 * 
 */
package uk.co.sainsburys.utils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import uk.co.sainsburys.configuration.ParserConfigConstants;
import uk.co.sainsburys.entities.Product;
import uk.co.sainsburys.parser.ProductParser;

/**
 * @author Michail Vasilakopoulos
 *  @version 0.1a May 12 2016
 *
 */
public class ProductCalculationsUtilsTest {

	@Test
	public void test() {
		List<String> productsURLsList = null;
		List<Product> productsList = new ArrayList<Product>();
		
		try {
			productsURLsList = ProductParser.parseProductsURLs(ParserConfigConstants.URL);
			productsList = ProductParser.parseAllProductsDetails(productsURLsList);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		Assert.assertTrue(new BigDecimal("15.10").compareTo(ProductCalculationsUtils.calculateProductListSum(productsList)) == 0);
	}

}
