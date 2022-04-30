package com.csci5308.kaloria.dietSuggestions.activityLevel;

import java.io.Serializable;

public class ActivityLevel implements Serializable, IActivityLevel {
	private final String description;
	private final double factor;

	public ActivityLevel(String description, double factor) {
		this.description = description;
		this.factor = factor;
	}

	public String getDescription() {
		return description;
	}

	public double getFactor() {
		return factor;
	}
}
