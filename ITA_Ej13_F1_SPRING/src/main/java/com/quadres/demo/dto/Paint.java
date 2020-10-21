package com.quadres.demo.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//En esta clase mapeamos la entidad PAINT de BBDD para que luego puedan ser utilizadas en java.


@Entity  // anotacion para decir que es una entidad de bbdd
@Table(name="paint")//en este caso la clase y la tabla se llaman igual, pero esto serviria, por si se llaman diferente

public class Paint {
	 
		//Atributos de entidad paint
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id;
		@Column(name = "author")//no hace falta si se llama igual
		private String author= "ANONIMO";
		@Column(name = "name")//no hace falta si se llama igual
		private String name;
		@Column(name = "price")//no hace falta si se llama igual
		private double price;
		@Temporal(TemporalType.TIMESTAMP)
		private Date date_entry;
		
		
		// Join con shop, al ser muchos a uno, nos devuelve solo una shop
		@ManyToOne
	    @JoinColumn(name="shop_id")
	    private Shop shop;
		
		
	    //CONSTRUCTORES VACIO Y COMPLETO		
		public Paint() {
		
		}

		public Paint(Long id, String author, String name, double price, Date date_entry, Shop shop) {
			this.id = id;
			this.author = author;
			this.name = name;
			this.price = price;
			this.date_entry = date_entry;
			this.shop = shop;
		}

		
		
		//GETTERS
		public Long getId() {
			return id;
		}

		public String getAuthor() {
			return author;
		}
		
		public String getName() {
			return name;
		}
		
		public double getPrice() {
			return price;
		}
		
		public Date getDateEntry() {
			return date_entry;
		}
		
		public Shop getShop() {
			return shop;
		}		
		
		
		
		// SETTERS
		public void setId(Long id) {
			this.id = id;
		}

		public void setAuthor(String author) {
			this.author = author;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public void setDateEntry(Date date_entry) {
			this.date_entry = date_entry;
		}

		public void setShop(Shop shop) {
			this.shop = shop;
		}
		
		

		//Metodo impresion de datos por consola
		@Override
		public String toString() {
			return "Paint [id=" + id + ", author=" + author + ", name=" + name + ", price=" + price
					+ ", date entry=" + date_entry + ", shop=" + shop + "]";
		}

}
