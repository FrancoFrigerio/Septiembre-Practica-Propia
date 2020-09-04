package ar.com.EducacionIT.dao;

import java.util.List;

import ar.com.EducacionIT.app.Domain.Producto;
import ar.com.EducacionIT.app.Domain.TipoProducto;
import ar.com.EducacionIT.dao.exceptions.DuplicateException;
import ar.com.EducacionIT.dao.exceptions.GenericExeption;

public interface ProductoRepository {
	public Producto getProducto(String codigo) throws GenericExeption;
	
	public List<Producto> findProductos() throws GenericExeption;
	
	public Producto createProducto (Producto producto) throws DuplicateException, GenericExeption;
	
	public Producto updateProducto (Producto producto) throws GenericExeption;
	
	public List<TipoProducto> findTipoProductos()throws GenericExeption;
	
	public List<Producto> findByDescripcion(String descripcion) throws GenericExeption;
	
}
