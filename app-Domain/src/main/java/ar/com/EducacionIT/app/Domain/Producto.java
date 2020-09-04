package ar.com.EducacionIT.app.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name="producto") //dice con que tabla se va a mapear en la bd

public class Producto {
		
	@Id
	//al poner id ya se asume que es una columna..
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
private String titulo;
	
	@Column(name="precio")
private Float precio;
	
	@Column(name="codigo", unique = true) //unique, porque el codigo no se puede repetir
	private String codigo;
	
	
	
		//**************RELACION MUCHOS A UNO*****************
	@ManyToOne   //por la relacion de producto a tipo de producto..
		//(que son de muchos a uno)
	
	@JoinColumn(name="tipo_producto",referencedColumnName = "id")
	//(**de la tabla de origen la clave con la que conectas a la otra tabla de destino** **referenced.... es la columna con la que conectas a la tabla de destino  )
private TipoProducto tipoProducto;

private void Prducto() {
	// TODO Auto-generated method stub

}



public Producto(Long id, String titulo, Float precio, String codigo, TipoProducto tipoProducto) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.precio = precio;
	this.codigo = codigo;
	this.tipoProducto = tipoProducto;
}



public Producto(String titulo, Float precio, TipoProducto tipoProducto) {
	super();
	this.titulo = titulo;
	this.precio = precio;
	this.tipoProducto = tipoProducto;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public Float getPrecio() {
	return precio;
}

public void setPrecio(Float precio) {
	this.precio = precio;
}

public TipoProducto getTipoProducto() {
	return tipoProducto;
}

public void setTipoProducto(TipoProducto tipoProducto) {
	this.tipoProducto = tipoProducto;
}



public String getCodigo() {
	return codigo;
}



public void setCodigo(String codigo) {
	this.codigo = codigo;
}

}
