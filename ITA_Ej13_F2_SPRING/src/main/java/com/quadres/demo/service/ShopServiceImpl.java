package com.quadres.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quadres.demo.dao.IShopDAO;
import com.quadres.demo.dto.Shop;

@Service
public class ShopServiceImpl implements IShopService {

	//Utilizamos los metodos de la interface IShopDAO, es como si instaciaramos.
	@Autowired
	IShopDAO iShopDAO;
	
	@Override
	public Shop createShop(Shop shop) {		
		
		return iShopDAO.save(shop);
	}

	@Override
	public List<Shop> selectAllShops() {
		
		return iShopDAO.findAll();
	}
	
	@Override
	public Shop selectShopById (Long id) {
		
		return iShopDAO.findById(id).get();
	}
	
	public List<Shop> selectShopByName (String name) {
		return iShopDAO.findByName(name);
	}

	@Override
	public Shop updateShop(Shop shop) {
		return iShopDAO.save(shop);
	}

	@Override
	public void deleteShop(Long id) {
		iShopDAO.deleteById(id);	

	}
	
}
