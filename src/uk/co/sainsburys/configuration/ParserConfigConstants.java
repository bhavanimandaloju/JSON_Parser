/**
 * 
 */
package uk.co.sainsburys.configuration;

/**
 * Contains various Product JSON Parser configuration constants 
 * 
 * @author Mike Vasilakopoulos
 * @version 0.1a May 12 2016
 *
 */
public class ParserConfigConstants {
	public static final String URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html"; 
	public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30";
	public static final String PRODUCT_LINK_PATTERN = "div.productInfo > h3 > a";
	public static final String PRODUCT_TITLE_PATTERN = "div.productTitleDescriptionContainer h1";
	public static final String PRODUCT_DESCRIPTION_PATTERN = "div.productText p";
	public static final String PRODUCT_PRICE_UNIT_PATTERN = "p.pricePerUnit";
}
