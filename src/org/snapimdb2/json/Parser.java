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
import org.snapimdb2.dao.AddMovieDAO;


public class Parser {
	public static int movie_id_counter = 0;
	
	public static void main(String[] args){
		AddMovieDAO dao = new AddMovieDAO();
		
		for(int i=100000; i<= 999999; i++){
			try {
				String movieID = "tt0" + i; 
				JSONObject json = readJsonFromUrl("http://www.omdbapi.com/?i=" + movieID +"&plot=short&r=json");
				
				String title = json.get("Title").toString();
				
				String year = (String)json.get("Year");
				if(!title.equals("N/A"))
					title = title + " (" + year + ")";
				
				String duration = json.get("Runtime").toString();
				if(duration.equals("N/A"))
					continue;
				
				String director = json.get("Director").toString();
				if(director.equals("N/A"))
					continue;
				
				String contentRating = json.get("Rated").toString();
				if(contentRating.equals("N/A"))
					continue;
				
				String genre = json.get("Genre").toString();
				if(genre.equals("N/A"))
					continue;
				
				String description = json.get("Plot").toString();
				if(description.equals("N/A"))
					continue;
				
				System.out.println("title: "+title);
				System.out.println("dur: "+duration);
				System.out.println("dir: "+director);
				System.out.println("content: "+contentRating);
				System.out.println("genre: "+genre);
				System.out.println("desc: "+description);
				System.out.println("-----------------------------");
				
				dao.addMovie(movie_id_counter++, duration, title, director, contentRating, genre, description);
				
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
