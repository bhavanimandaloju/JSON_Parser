/**
 * 
 */
package uk.co.sainsburys.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uk.co.sainsburys.configuration.ParserConfigConstants;
import uk.co.sainsburys.entities.Product;

/**
 * @author Michail Vasilakopoulos
 *  @version 0.1a May 12 2016
 */
public class ProductParserTest {

	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseProductsURLs(java.lang.String)}.
	 */
	@Test
	public void testParseProductsURLs() {
		List<String> productsURLList = null;
		
		try {
			productsURLList = ProductParser.parseProductsURLs(ParserConfigConstants.URL);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		assertFalse(productsURLList.isEmpty());
		assertTrue(productsURLList.size() == 7);
	}
	
	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseProductsURLs(java.lang.String)}.
	 */
	@Test
	public void testParseProductsURLsWrongURL() {
		List<String> productsURLList = null;
		
		try {
			productsURLList = ProductParser.parseProductsURLs("http://www.google.com");
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		assertTrue(productsURLList.isEmpty());
		assertTrue(productsURLList.size() == 0);
	}


	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseProductDetails(java.lang.String)}.
	 */
	@Test
	public void testParseProductDetails() {
		String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html";
		Product product = null;
		
		try {
			product = ProductParser.parseProductDetails(url);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		assertNotNull(product);
		assertEquals("Sainsbury's Apricot Ripe & Ready x5", product.getTitle());
		assertEquals("38kb", product.getSize());
		assertEquals("Apricots", product.getDescription());
		assertTrue(new BigDecimal("3.50").compareTo(product.getUnit_price()) == 0);	
	}
	
	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseProductDetails(java.lang.String)}.
	 */
	@Test
	public void testParseProductDetailsWrongURL() {
		String url = "http://www.google.com";
		
		try {
			assertNull(ProductParser.parseProductDetails(url));
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
	}
		
	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseProductDetails(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testParseProductDetailsNullURL() {
		
		try {
			assertNull(ProductParser.parseProductDetails(null));
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseProductDetails(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testParseProductDetailsWithNNonUrlString() {
		try {
			ProductParser.parseProductDetails("any_string");
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseAllProductsDetails(java.util.List)}.
	 */
	@Test
	public void testParseAllProductsDetails() {
		List<String> productsURLsList = null;
		List <Product> productsList = null;
		
		try {
			productsURLsList = ProductParser.parseProductsURLs(ParserConfigConstants.URL);
			productsList = ProductParser.parseAllProductsDetails(productsURLsList);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		assertFalse(productsList.isEmpty());
		assertTrue(productsList.size() == 7);
	}
	
	/**
	 * Test method for {@link uk.co.sainsburys.parser.ProductParser#parseAllProductsDetails(java.util.List)}.
	 */
	@Test
	public void testParseAllProductsDetailsWithNull() {
		List<String> productsURLsList = new ArrayList<String>();
		productsURLsList.add("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html");
		productsURLsList.add("null");
		productsURLsList.add("any_string");
		
		List <Product> productsList = null;
		
		try {
			productsList = ProductParser.parseAllProductsDetails(productsURLsList);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		assertFalse(productsList.isEmpty());
		assertTrue(productsList.size() == 1);
	}

}
