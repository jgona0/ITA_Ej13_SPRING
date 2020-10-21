package com.quadres.demo.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

//En esta clase mapeamos la entidad SHOP de BBDD para que luego puedan ser utilizadas en java.

@Entity  // anotacion para decir que es una entidad de bbdd
@Table(name="shop")//en este caso la clase y la tabla se llaman igual, pero esto serviria, por si se llaman diferente

public class Shop {
	 
		//Atributos de entidad shop
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id;
		@Column(name = "name")//no hace falta si se llama igual
		private String name;
		@Column(name = "capacity")//no hace falta si se llama igual
		private Long capacity;
		
		
		
		// Join con paint, al ser uno a muchos, nos devuelve una lista
		@OneToMany (mappedBy = "shop") // con mapped by decimos que la tabla que "manda" será la de shop
	    //@JoinColumn(name="id")   --> Con esta instrucción no funcionaba bien el delete y el update
	    private List<Paint> paint;
	    
	    
	    
	    //CONSTRUCTORES VACIO Y COMPLETO
		public Shop() {
		
		}

		public Shop(Long id, String name, Long capacity) {
			this.id = id;
			this.name = name;
			this.capacity = capacity;
		}

		
		
		//GETTERS 
		public Long getId() {
			return id;
		}	
		
		public String getName() {
			return name;
		}
		
		public Long getCapacity() {
			return capacity;
		}
		
		//Retorna una lista de Paints, al ser de uno a muchos
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Paint")
		public List<Paint> getPaint() {
			return paint;
		}
		

		
		//SETTERS
		public void setId(Long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setCapacity(Long capacity) {
			this.capacity = capacity;
		}

		public void setPaint(List<Paint> paint) {
			this.paint = paint;
		}

		
		
		//Metodo impresion de datos por consola
		@Override
		public String toString() {
			return "Shop [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
		}
	
}
