package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	
	@Column (name="NOMBRE")
	private String nombre;
	@Column (name="PRECIO")
	private double precio;
	
	
	public Item() {
		super();
	}
	public Item(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
