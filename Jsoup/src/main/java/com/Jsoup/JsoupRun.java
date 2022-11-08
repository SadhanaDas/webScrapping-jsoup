package com.Jsoup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupRun {

	static final String DB_URL = "jdbc:mysql://localhost:3306/movie";
	static final String USER = "root";
	static final String PASS = "root";
	
	public static void main(String[] args) throws IOException{
		Document doc= Jsoup.connect("https://www.metacritic.com/browse/movies/score/metascore/all/filtered?sort=desc").get();
		Elements body=doc.select("tbody");
//		System.out.println(body.select("tr").size());
		Elements titles=doc.select("td.clamp-image-wrap img");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String query = "INSERT INTO movielist (title,date,metascore,review) values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			conn.setAutoCommit(false); 
			for( Element e : body.select("tr")) {
				
				for(int i=0;i<titles.size();i++) {
					
//					String title =titles.get(i).attr("alt");
//					System.out.println(title);
//					String date =e.select("td.clamp-summary-wrap div.clamp-details span").get(i).text();
//					System.out.println(date);
//					String metascore=e.select("td.clamp-summary-wrap div.clamp-score-wrap a.metascore_anchor div").get(i).text();
//					//int metascore = Integer.parseInt(metascore1);
//					System.out.println(metascore);
//					String review=e.select("td.clamp-summary-wrap div.summary").text();
//					System.out.println(review);
					
					ps.setString(1,e.select("td.clamp-image-wrap img").attr("alt"));
					ps.setString(2,e.select("td.clamp-summary-wrap div.clamp-details span").text());
					ps.setString(3,e.select("td.clamp-summary-wrap div.clamp-score-wrap a.metascore_anchor div").text());
					ps.setString(4,e.select("td.clamp-summary-wrap div.summary").text());
					ps.addBatch();
				}		
				
			}
			ps.executeBatch();
			conn.commit();
			conn.close();
		}catch  (Exception e1){
			e1.printStackTrace();
		}		
	}
}
