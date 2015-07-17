package org.snapimdb2.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
	
	public static void main(String[] args){
		for(int i=100000; i<= 999999; i++){
			int naCount = 0;
			try {
				String movieID = "tt0" + i; 
				JSONObject json = readJsonFromUrl("http://www.omdbapi.com/?i=" + movieID +"&plot=short&r=json");
				
				String title = json.get("Title").toString();
				
				String year = (String)json.get("Year");
				if(year.equals("N/A"))
					naCount++;
				else
					title = title + " (" + year + ")";
				
				String duration = json.get("Runtime").toString();
				if(duration.equals("N/A"))
					naCount++;
				
				String director = json.get("Director").toString();
				if(duration.equals("N/A"))
					naCount++;
				
				String contentRating = json.get("Rated").toString();
				if(duration.equals("N/A"))
					naCount++;
				
				String genre = json.get("Genre").toString();
				if(duration.equals("N/A"))
					naCount++;
				
				String description = json.get("Plot").toString();
				if(duration.equals("N/A"))
					naCount++;
				
				if(naCount == 0){
					//push into table..Still there are conflicts .. N/A movies still appear. Reason unknown :(
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (NullPointerException e){
				System.out.println("Not found..");
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static JSONObject readJsonFromUrl(String url) throws MalformedURLException, IOException, ParseException{
		InputStream is = new URL(url).openStream();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))));
		
		return json;
	}
	
}
