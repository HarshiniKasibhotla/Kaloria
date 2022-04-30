package com.csci5308.kaloria.feedback.ratingDietician;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRating {
    long getAvergeDieticianRating(ResultSet reviews) throws SQLException;
}
