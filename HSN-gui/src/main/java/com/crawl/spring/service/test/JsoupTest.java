package com.crawl.spring.service.test;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class JsoupTest {

	public static void main (String args[]) throws IOException{
		JsoupTest.processPage("https://www.amazon.es/s/ref=sr_hi_1?rh=n%3A1748200031&bbn=1748200031&ie=UTF8&qid=1459613157");
	}
	
	public static void processPage(String URL) throws IOException{
		Document doc = Jsoup.connect(URL).get();
		//get all links and recursively call the processPage method
		Elements categories = doc.select("div.left_nav ul li a");
		for(Element category: categories){
//			System.out.println(category.toString().replace("&amp;", "&&"));
			System.out.println(category.attr("href").replace("&amp;", "&&"));
			System.out.println(category.text());
		}
	}
}
