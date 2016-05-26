/**
 * 
 */
package uk.co.sainsburys.parser;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import uk.co.sainsburys.configuration.ParserConfigConstants;
import uk.co.sainsburys.entities.Product;

/**
 * The ProductParser provides methods that can be used to extract
 * information regarding the products available on Saibury's Online Store 
 * 
 * @author Michail Vasilakopoulos
 * @version 0.1a May 12 2016
 *  
 */
public class ProductParser {
	
	/**
	 * Parses the provided Sainsbury's URL and returns a list of 
	 * any Product URL found on the site
	 * 
	 * @param url the String with the URL
	 * @return List<String> the List of Products URLs 
	 * @throws IOException for signalling run-time failure of reading and writing operations
	 */
	public static List<String> parseProductsURLs(String url) throws IOException {
		System.out.println("Parsing available Sainsbury's products URLS...");
		
		Document doc = Jsoup.connect(url).userAgent(ParserConfigConstants.USER_AGENT).get();
		Elements elements = doc.select(ParserConfigConstants.PRODUCT_LINK_PATTERN);
		
		List<String> productsURLsList = new ArrayList<String>();
		
		for (Element aElement : elements) {
			productsURLsList.add(aElement.attr("href"));
		}
		
		System.out.println("Sainsbury's available Products URLs parsed successfully...");
		
		return productsURLsList;		
	}
	
	
	/**
	 * Parses the provided Sainbury's Product page URL to extract 
	 * information regarding the Product and
	 * returns a Product with it's details
	 *  
	 * @param url the String with the URL
	 * @return Product the Product with it's details
	 * @throws IOException for signalling run-time failure of reading and writing operations
	 */
	public static Product parseProductDetails(String url) throws IOException, IllegalArgumentException {
		Product product = null;
		
		Connection conn = Jsoup.connect(url);
		Connection.Response response = conn.userAgent(ParserConfigConstants.USER_AGENT)
				.timeout(10000)
				.execute();
		
		Document doc = conn.get();
		
		
		
		Element element = null;
		element = doc.select(ParserConfigConstants.PRODUCT_TITLE_PATTERN).first();		
		if (element != null) {
			System.out.println("Processing Product: " + element.text());
			product = new Product();
			product.setTitle(element.text());
		}
		
		if (response.bodyAsBytes().length > 0 && product != null) {
			product.setSize(response.bodyAsBytes().length/1024 + "kb");
		}
		
		element = null;
		element = doc.select(ParserConfigConstants.PRODUCT_DESCRIPTION_PATTERN).first();
		if (element != null) {
			product.setDescription(element.text());
		}
		
		element = null;
		element = doc.select(ParserConfigConstants.PRODUCT_PRICE_UNIT_PATTERN).first();
		if (element != null) {
			String unit_price = element.text().substring(1, element.text().indexOf("/"));
			product.setUnit_price(new BigDecimal(unit_price));
		}
		
		
		return product;
	}
	
	
	/**
	 * Uses a List of Product String URLs to extract information
	 * and returns a List of Products and their details. 
	 * 
	 * @param urls the List of String with the Products URLs
	 * @return List<Product> the List of the Products
	 * @throws IOException for signalling run-time failure of reading and writing operations
	 */
	public static List<Product> parseAllProductsDetails(List<String> urls) throws IOException {
		 List<Product> productsList = new ArrayList<Product>();
		 
		 for (String url : urls) {
			 try {
				Product product = parseProductDetails(url);
				 productsList.add(product);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}catch (MalformedURLException e) {
				e.printStackTrace();
			}
		 }
		 
		 return productsList;
	}

}
