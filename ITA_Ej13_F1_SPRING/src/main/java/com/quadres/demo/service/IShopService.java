package com.quadres.demo.service;

import java.util.List;

import com.quadres.demo.dto.Shop;

//En esta interface definimos los métodos que se deberán implementar en el service. Serán las acciones que podemos hacer contra bbdd a nivel de Shops

public interface IShopService {

	//Metodos del CRUD
	
		public Shop createShop(Shop shop);	//Crea una shop
	
		public List<Shop> selectAllShops(); //Seleccionar todas las shops 
		
		public Shop selectShopById (Long id); //Seleccionar una shop por id
		
		public Shop updateShop (Shop shop); //Hacer update de una shop
		
		public void deleteShop (Long id); //Borrar una shop
	
}
