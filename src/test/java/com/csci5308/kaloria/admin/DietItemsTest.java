package com.csci5308.kaloria.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import com.csci5308.kaloria.admin.dietItems.DietItems;



public class DietItemsTest {
	
	@InjectMocks
	DietItems dietitems;
	
	@BeforeEach
	public void setUp() {
		dietitems = new DietItems();
	}

	@Test
	public void setIdTest() {
		dietitems.setItemId(200);
		assertTrue(200 == dietitems.getItemId());
	}
	
	@Test
	public void getIdTest() {
		dietitems.setItemId(30);
		assertFalse(0 == dietitems.getItemId());
	}
	
	@Test
	public void setNutrientType() {
		dietitems.setNutrientType("Proteins");
		assertEquals("Proteins", dietitems.getNutrientType());
	}

	@Test
	public void getNutrientType() {
		dietitems.setNutrientType("Fat");
		assertNotEquals("Carbs", dietitems.getNutrientType());
	}
	
	@Test
	public void setItemName() {
		dietitems.setItemName("Paneer");
		assertEquals("Paneer", dietitems.getItemName());
	}
	
	@Test
	public void getItemName() {
		dietitems.setItemName("Rice");
		assertNotEquals("Chips", dietitems.getItemName());
	}
	
	@Test
	public void setCalories() {
		dietitems.setCalories(500);
		assertTrue(500 == dietitems.getCalories());
	}
	
	@Test
	public void getCalories() {
		dietitems.setCalories(30);
		assertFalse(0 == dietitems.getCalories());
	}
	
	@Test
	public void isNutrientTypeValidTest() {
		assertTrue(DietItems.isNutrientTypeValid("fat"));
		assertFalse(DietItems.isNutrientTypeValid(""));
	}
	
	@Test
	public void isItemNameValidTest() {
		assertTrue(DietItems.isItemNameValid("cheese"));
		assertFalse(DietItems.isItemNameValid(""));
	}
	
	@Test
	public void isCaloriesValid() {
		assertTrue(DietItems.isCaloriesValid(520));
		assertFalse(DietItems.isCaloriesValid(0));
	}
	
	@Test
	public void setCategory() {
		dietitems.setCategory("Lunch");
		assertEquals("Lunch", dietitems.getCategory());
	}
	
	@Test
	public void getCategory() {
		dietitems.setCategory("Dinner");
		assertNotEquals("Lunch", dietitems.getCategory());
	}
	@Test
	public void setHealth(){
		dietitems.setHealth("Thyroid");
		assertEquals("Thyroid", dietitems.getHealth());
	}
	
	@Test
	public void getHealth() {
		dietitems.setHealth("Diabetes");
		assertNotEquals("PCOD", dietitems.getHealth());
	}
	@Test
	public void setAllergy(){
		dietitems.setAllergy("Gluten");
		assertEquals("Gluten", dietitems.getAllergy());
	}
	@Test
	public void getAllergy() {
		dietitems.setAllergy("Lactose");
		assertNotEquals("None", dietitems.getAllergy());
	}
	@Test
	public void setMeal() {
		dietitems.setMeal("Vegetarian");
		assertEquals("Vegetarian", dietitems.getMeal());
	}
	
	@Test
	public void getMeal() {
		dietitems.setMeal("Vegetarian");
		assertNotEquals("Vegan", dietitems.getMeal());
	}
		
	
}
