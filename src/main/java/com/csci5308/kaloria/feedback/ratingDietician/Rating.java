package com.csci5308.kaloria.feedback.ratingDietician;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Rating implements IRating{

    private static Rating ratingInstance;
    private Rating(){}
    public static Rating getRatingInstance(){
        if(ratingInstance == null) {
            ratingInstance = new Rating();
        }
        return ratingInstance;
    }

    @Override
    public long getAvergeDieticianRating(ResultSet dieticianReviews) throws SQLException {
        int ratingSum = 0;
        int count = 0;
        while(dieticianReviews.next()) {
            int rating = dieticianReviews.getInt("rating");
            if(rating != 0) {
                ratingSum += rating;
                count++;
            }
        }
        if(count != 0){
            return ratingSum/count;
        }
        return 0;
    }
}
