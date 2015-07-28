/*
 *  @version     1.0, 19-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.snapimdb2.dao.AddImdbMovieDAO;

public class ImdbSpider {
    
    public static InputStream is = null;
    public static JSONParser parser = new JSONParser();
    
    public static boolean parseAndStoreMovie(AddImdbMovieDAO addImdbMovieDAO) throws MalformedURLException, IOException, ParseException, SQLException{  
        
        int movieId = (int) AddImdbMovieDAO.maxMovieId;
        String finalMovieId = "tt"+String.format("%07d", AddImdbMovieDAO.maxImdbId); 
        
        JSONObject json = readJsonFromUrl("http://www.omdbapi.com/?i=" + finalMovieId +"&plot=short&r=json");
        
        String movieName = json.get("Title").toString();
        
        String year = (String)json.get("Year");
        
        if(!year.equals("N/A"))
            year = year + " (" + year + ")";
        
        String duration = json.get("Runtime").toString();
        if(duration.equals("N/A"))
            return false;
        
        String director = json.get("Director").toString();
        if(director.equals("N/A"))
            return false;
        
        String contentRating = json.get("Rated").toString();
        if(contentRating.equals("N/A"))
            return false;
        
        String genre = json.get("Genre").toString();
        if(genre.equals("N/A"))
            return false;
        
        String description = json.get("Plot").toString();
        if(description.equals("N/A"))
            return false;
        
        addImdbMovieDAO.addImdbMovie(movieId, duration, movieName, director, contentRating, genre, description);
        
        return true;
    }
    
    public static JSONObject readJsonFromUrl(String url) throws MalformedURLException, IOException, ParseException{
        is = new URL(url).openStream();
        JSONObject json = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))));
        return json;
    }
}
