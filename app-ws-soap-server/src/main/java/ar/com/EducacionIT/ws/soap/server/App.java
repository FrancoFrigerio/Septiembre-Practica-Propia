package ar.com.EducacionIT.ws.soap.server;

import java.util.List;

import ar.com.EducacionIT.app.Domain.Producto;
import ar.com.EducacionIT.service.ProductoService;
import ar.com.EducacionIT.service.impl.ProductoServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ProductoService ps = new ProductoServiceImpl();
		List<Producto> productos = ps.findAll();
		
		System.out.println(productos);
		
	}
}
