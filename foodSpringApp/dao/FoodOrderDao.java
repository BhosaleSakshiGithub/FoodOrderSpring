package com.food.foodSpringApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodSpringApp.dto.FoodOrder;
import com.food.foodSpringApp.dto.Item;
import com.food.foodSpringApp.repository.FoodOrderRepo;
import com.food.foodSpringApp.repository.ItemRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepo foodOrderRepo;
	
	@Autowired
	ItemRepo itemRepo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodorder)
	{
		List<Item> listOfItems = foodorder.getItem();
		List<Item> res= new ArrayList<Item>();
		if (listOfItems.isEmpty()) {
			foodorder = foodOrderRepo.save(foodorder);
		} else {
			foodorder = foodOrderRepo.save(foodorder);
			for (Item iteam : listOfItems) {
				iteam.setFoodorder(foodorder);
				res.add(itemRepo.save(iteam));
			}
			foodorder.setItem(res);
		}
		return foodorder;
		
	}
	
	public Optional<FoodOrder> getFoodOrderById(int id)
	{
		return foodOrderRepo.findById(id);
	}
	
	public List<FoodOrder> getAllFoodOrder()
	{
		return foodOrderRepo.findAll();
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder)
	{
		return foodOrderRepo.save(foodOrder);
	}
	
	public void deleteFoodOrder(int id)
	{
		foodOrderRepo.deleteById(id);;
	}
}
