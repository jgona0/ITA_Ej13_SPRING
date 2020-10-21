package com.quadres.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.quadres.demo.dto.Shop;


//Interfaz que extiende de JPA, para que la clase del service que le hara el autowired pueda utilizar los métodos JPA de acceso a bbdd

public interface IShopDAO extends JpaRepository<Shop, Long>{

	public List<Shop> findByName(String name);
}
