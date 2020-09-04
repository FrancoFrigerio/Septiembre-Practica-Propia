package ar.com.EducacionIT.service.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.EducacionIT.app.Domain.Producto;
import ar.com.EducacionIT.app.Domain.TipoProducto;
import ar.com.EducacionIT.dao.ProductoRepository;
import ar.com.EducacionIT.dao.exceptions.DuplicateException;
import ar.com.EducacionIT.dao.exceptions.GenericExeption;
import ar.com.EducacionIT.service.ProductoService;

public class ProductoServiceImpl implements ProductoService{
		
	private ProductoRepository porductoRepository;
	
	public ProductoServiceImpl() {
		this.porductoRepository = new ProductoRepository() {
			
			@Override
			public Producto updateProducto(Producto producto) throws GenericExeption {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Producto getProducto(String codigo) throws GenericExeption {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<TipoProducto> findTipoProductos() throws GenericExeption {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Producto> findProductos() throws GenericExeption {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Producto> findByDescripcion(String descripcion) throws GenericExeption {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Producto createProducto(Producto producto) throws DuplicateException, GenericExeption {
				// TODO Auto-generated method stub
				return null;
			}
		};
		// TODO Auto-generated constructor stub
	}
	
	//el repository es para poder acceder a un producto en la base de dato
	@Override
	public List<Producto> findAll() {
		List<Producto> listado = new ArrayList<>();
		
		try {
			this.porductoRepository.findProductos();
		} catch (GenericExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listado;
		
	}

	@Override
	public Producto getById(Long idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto deleteProductoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto updateProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

}
