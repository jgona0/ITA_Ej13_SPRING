package com.quadres.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quadres.demo.dto.Shop;
import com.quadres.demo.service.ShopServiceImpl;



//Capa controller donde la ruta origen será .../api

@RestController
@RequestMapping("/api")
public class ShopController {

	@Autowired
	ShopServiceImpl shopServiceImpl;
	
	// CREATE shop
	@PostMapping("/shops")
	public Shop postEmployee(@RequestBody Shop shop) {
		return shopServiceImpl.createShop(shop);
	}
	
	
	//SELECT todas las shops
	@GetMapping("/shops")
	public List<Shop> getAllShops(){
		return shopServiceImpl.selectAllShops();
	}
	
	
	//SELECT una shop por id
	@GetMapping("/shops/{id}")
	public Shop getShopById(@PathVariable(name="id") Long id){
		return shopServiceImpl.selectShopById(id);
	}
	
	
	//UPDATE una shop
	@PutMapping("/shops/{id}")
	public Shop updateShop(@PathVariable(name="id")Long id, @RequestBody Shop shop) {
		
		//Guardamos la shop que queremos actualizar
		Shop shop_to_updt = shopServiceImpl.selectShopById(id);
		System.out.println("Se actualiza la shop: " +shop_to_updt);
		
		//Setteamos su nombre y capacidad
		shop_to_updt.setName(shop.getName());
		shop_to_updt.setCapacity(shop.getCapacity());
		
		// asignamos la actualización y retornamos el objeto actualizado
		shop =  shopServiceImpl.updateShop(shop_to_updt);
		System.out.println("Por el employee: " +shop);
		
		return shop;

	}
	
	
	//DELETE una shop por id
	@DeleteMapping("/shops/{id}")
	public void deleteShop(@PathVariable(name="id")Long id) {

		System.out.println("Se borra la shop con id: " +id);

		shopServiceImpl.deleteShop(id);
		
		System.out.println("SHOP BORRADA");

	}
	
}
