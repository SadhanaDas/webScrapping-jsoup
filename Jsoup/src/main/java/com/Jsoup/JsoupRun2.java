package com.Jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupRun2 {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.metacritic.com/browse/movies/score/metascore/all/filtered?sort=desc")
				.get();
		Elements body = doc.select("tbody");
//        System.out.println(body.select("tr").size());

//		ArrayList <Element> element = new ArrayList<>();

		for (Element e : body.select("tr")) {
			String title = e.select("td.clamp-image-wrap img").attr("alt");
			System.out.println(title);
			String date = e.select("td.clamp-summary-wrap div.clamp-details span").text();
			System.out.println(date);
			String metascore = e.select("td.clamp-summary-wrap div.clamp-score-wrap a.metascore_anchor div").text();
			System.out.println(metascore);
			String review = e.select("td.clamp-summary-wrap div.summary").text();
			System.out.println(review);
		}
	}

}
