package com.crawl.spring.service.test;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class JsoupTest {

	public static void main (String args[]) throws IOException{
		JsoupTest.processPage("http://www.amazon.es/gp/site-directory/ref=nav_shopall_btn");
	}
	
	public static void processPage(String URL) throws IOException{
		Document doc = Jsoup.connect(URL).get();
		//get all links and recursively call the processPage method
		Elements categories = doc.select("div.popover-grouping a.nav_a");
		for(Element category: categories){
//			System.out.println(category.toString().replace("&amp;", "&&"));
			System.out.println(category.attr("href").replace("&amp;", "&&"));
			System.out.println(category.text());
		}
	}
}
