package org.snapimdb2;
public class Rating {
    
    private long totalNumberOfRatings;
    private long totalSumOfRatings;
    
    public Rating() {
        totalNumberOfRatings = 0;
        totalSumOfRatings = 0;
    }
    
    public double getRating(){
        return (((double)totalSumOfRatings)/totalNumberOfRatings);
    }
    
    public void addRating(int rating){
        totalNumberOfRatings++;
        totalSumOfRatings+=rating;
    }
}
