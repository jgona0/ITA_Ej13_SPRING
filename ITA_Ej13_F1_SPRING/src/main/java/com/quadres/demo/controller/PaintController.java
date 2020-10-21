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
import com.quadres.demo.dto.Paint;
import com.quadres.demo.dto.Shop;
import com.quadres.demo.service.PaintServiceImpl;
import com.quadres.demo.service.ShopServiceImpl;


//Capa controller donde la ruta origen será .../api

@RestController
@RequestMapping("/api")
public class PaintController {

	@Autowired
	PaintServiceImpl paintServiceImpl;
	
	@Autowired
	ShopServiceImpl shopServiceImpl;

	
	// CREATE paint
	@PostMapping("/shops/{id}/pictures")
	public Paint postPaint(@PathVariable(name="id")Long id, @RequestBody Paint paint) {
		
		//Seleccionamos la shop donde guardaremos el paint
		Shop paint_shop = shopServiceImpl.selectShopById(id);
		
		//Recuperamos su capacidad y cuantos cuadros tiene actualmente
		Long capacity =  paint_shop.getCapacity();
		Long paints_shop = (long) paintServiceImpl.selectPaintsShop(id).size();
		
		if (paints_shop < capacity) {
			// asignamos la shop al paint
			paint.setShop(paint_shop);
			return paintServiceImpl.createPaint(paint);

		}else {
			System.out.println("No caben más cuadros en la tienda:" +paint_shop.getName()+ " (id=" +paint_shop.getId()+ ")");
			return paint;
		}	
		
	}
	
	
	//SELECT todos los paints
	@GetMapping("shops/pictures")
	public List<Paint> getAllPaints(){
		return paintServiceImpl.selectAllPaints();
	}
	
	//SELECT paint por id
	@GetMapping("shops/pictures/{id}")
	public Paint getPaintById(@PathVariable(name="id") Long id) {
		return paintServiceImpl.selectPaintById(id);
	}
	
	
	//SELECT paints por Shop ID
	@GetMapping("shops/{id}/pictures")
	public List<Paint> getPaintsShop(@PathVariable(name="id") Long id){
		return paintServiceImpl.selectPaintsShop(id);
	}
	
	
	//UPDATE un paint
	@PutMapping("/shops/pictures/{id}")
	public Paint updatePaint(@PathVariable(name="id")Long id, @RequestBody Paint paint) {
		
		//Guardamos el paint que queremos actualizar
		Paint paint_to_updt = paintServiceImpl.selectPaintById(id);
		System.out.println("Se actualiza el paint: " +paint_to_updt);
				
		//Setteamos su nombre y capacidad
		paint_to_updt.setAuthor(paint.getAuthor());
		paint_to_updt.setName(paint.getName());
		paint_to_updt.setPrice(paint.getPrice());
		paint_to_updt.setDateEntry(paint.getDateEntry());
		paint_to_updt.setShop(paint.getShop());
				
		// asignamos la actualización y retornamos el objeto actualizado
		paint =  paintServiceImpl.updatePaint(paint_to_updt);
		System.out.println("Por el paint: " +paint);
				
		return paint;
	}
	
	
	//DELETE un paint por id
	@DeleteMapping ("shops/pictures/{id}")
	public void deletePaint(@PathVariable(name="id")Long id) {
		System.out.println("Se borra el paint con id: " +id);

		paintServiceImpl.deletePaint(id);
		
		System.out.println("PAINT BORRADA");
	}
	
	//DELETE paints por id_shop
		@DeleteMapping ("shops/{id}/pictures")
		public void deletePaintsShop(@PathVariable(name="id")Long id) {
			System.out.println("Se borran todos los paints de la shop con id: " +id);

			paintServiceImpl.deletePaintsShop(id);
			
			System.out.println("PAINTS BORRADOS");
		}
}
