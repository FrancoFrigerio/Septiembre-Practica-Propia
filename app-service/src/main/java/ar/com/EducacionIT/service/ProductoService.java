package ar.com.EducacionIT.service;

import java.util.List;

import ar.com.EducacionIT.app.Domain.Producto;

public interface ProductoService {
	/*
	 * Obtiene todos los productos de la base de datos
	 * */
	
	public List<Producto> findAll();

	public Producto getById(Long idProducto);
	
	public Producto getByCodigo(String codigo);
	
	public Producto deleteProductoById(Long id);
	
	public Producto updateProducto(Producto producto);
	
}
