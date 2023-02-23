package com.food.foodSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodSpringApp.dao.FoodOrderDao;
import com.food.foodSpringApp.dto.FoodOrder;

@RestController
@RequestMapping("/foodOrder")
public class InsertFoodOrderController {

	@Autowired
	FoodOrderDao foodOrderDao;
	
	@PostMapping
	public FoodOrder saveData(@RequestBody FoodOrder foodOrder)
	{
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	@GetMapping("/{id}")
	public FoodOrder getFoodOrderById(@PathVariable int id)
	{
		Optional<FoodOrder> op = foodOrderDao.getFoodOrderById(id);
		if(op.isEmpty()) {
			return null;
		}
		else {
			return op.get();
		}
	}
	
	@GetMapping
	public List<FoodOrder> getAllOrder() 
	{
		return foodOrderDao.getAllFoodOrder();
	}
	
	@PutMapping
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder)
	{
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	@DeleteMapping
	public String deleteFoodOrder(@RequestParam int id)
	{
		Optional<FoodOrder> op = foodOrderDao.getFoodOrderById(id);
		if(op.isPresent())
		{
			foodOrderDao.deleteFoodOrder(id);
			return "FoodOrder is deleted";
		}
		else {
			return "Data is not found";
		}
	}
}


