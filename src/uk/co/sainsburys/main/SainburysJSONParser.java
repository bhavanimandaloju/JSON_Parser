package uk.co.sainsburys.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uk.co.sainsburys.configuration.ParserConfigConstants;
import uk.co.sainsburys.entities.Product;
import uk.co.sainsburys.parser.ProductParser;
import uk.co.sainsburys.utils.ProductCalculationsUtils;

/**
 * 
 */

/**
 * The SainsburysJSONParser class consumes a webpage, 
 * processes the product urls and details and presents 
 * it in JSON array of all the products on the webpage
 * 
 * consume a webpage, process some data and present it.
 * 
 * @author Michail Vasilakopoulos
 *  @version 0.1a May 12 2016
 *
 */
public class SainburysJSONParser {
	
	public static void main(String[]  args) {
		List<String> productsURLsList = null;
		
		try {
			productsURLsList = ProductParser.parseProductsURLs(ParserConfigConstants.URL);

			if (productsURLsList.size() > 0) {
				List<Product> productsList = new ArrayList<Product>();
				
				productsList = ProductParser.parseAllProductsDetails(productsURLsList);
				
				Map<String, Object> jsonMap = new TreeMap<String, Object>();
				jsonMap.put("results", productsList);
				jsonMap.put("total", ProductCalculationsUtils.calculateProductListSum(productsList));
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(jsonMap);
				
				System.out.println("Products JSON Array :\n" + json );
				
			} else {
				System.out.println("No Products found...");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
