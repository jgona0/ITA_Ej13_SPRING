package com.quadres.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.quadres.demo.dto.Paint;


//Interfaz que extiende de JPA, para que la clase del service que le hara el autowired pueda utilizar los métodos JPA de acceso a bbdd

public interface IPaintDAO extends JpaRepository<Paint, Long> { 

	public List<Paint> findByShopId(Long id); // SELECT Paints por id de la shop
}
