package com.quadres.demo.service;

import java.util.List;

import com.quadres.demo.dto.Paint;

//En esta interface definimos los métodos que se deberán implementar en el service. Serán las acciones que podemos hacer contra bbdd a nivel de Paints

public interface IPaintService {
	
	public Paint createPaint(Paint paint);	//Crea un paint (asociado a una shop)
	
	public List<Paint> selectAllPaints(); //Seleccionar todas las paints 
	
	public Paint selectPaintById (long id); //Seleccionar un paint por ID
	
	public List<Paint> selectPaintsShop(Long id_shop); //Listar paints (de una shop)
	
	public Paint updatePaint (Paint paint); //Hacer update de un paint
	
	public void deletePaint (Long id); //Borrar un paint
	
	public void deletePaintsShop(Long id); //"Quemar" Borrar todos los paints de una shop

}
