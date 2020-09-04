package ar.com.EducacionIT.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import ar.com.EducacionIT.app.Domain.Producto;
import ar.com.EducacionIT.app.Domain.TipoProducto;
import ar.com.EducacionIT.dao.ProductoRepository;
import ar.com.EducacionIT.dao.exceptions.DuplicateException;
import ar.com.EducacionIT.dao.exceptions.GenericExeption;
import ar.com.EducacionIT.dao.hibernate.HibernateUtils;

public class ProductoRepositoryHibernateImpl implements ProductoRepository {

	private SessionFactory factory;
	
	public ProductoRepositoryHibernateImpl() {
		
		factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public Producto getProducto(String codigo) throws GenericExeption {
		
		Session session = factory.getCurrentSession();

		Producto producto = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Producto.class.getName() + " e where e.codigo=:codigo ";

			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			query.setParameter("codigo", codigo);

			// Execute query.
			Optional<Producto> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				producto = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return producto;
	}

	@Override
	public List<Producto> findProductos() {
		Session session = factory.getCurrentSession();

		List<Producto> products = new ArrayList<Producto>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Producto.class.getName() + " e ";

			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			// Execute query.
			products = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return products;
	}

	@Override
	public Producto createProducto(Producto producto) throws GenericExeption, DuplicateException {
		Session session = factory.getCurrentSession();

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			session.saveOrUpdate(producto);
			
			// Commit data.
			session.getTransaction().commit();
		}catch (ConstraintViolationException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw new DuplicateException(e.getCause().getMessage(),e);
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(),e);
		}finally {
			session.close();
		}
		return producto;
	}

	@Override
	public Producto updateProducto(Producto producto) throws GenericExeption {
		try {
			// return createProducto(producto);
			Session session = factory.getCurrentSession();

			try {
				// All the action with DB via Hibernate
				// must be located in one transaction.
				// Start Transaction.
				session.getTransaction().begin();

				// Create an HQL statement, query the object.
				String sql = "Select e from " + Producto.class.getName() + " e where e.codigo=:codigo ";

				// Create Query object.
				Query<Producto> query = session.createQuery(sql);
				
				query.setParameter("codigo", producto.getCodigo());

				// Execute query.
				Optional<Producto> productoOptional = query.uniqueResultOptional();

				Producto productoBean = null;
				if(productoOptional.isPresent()) {
					productoBean = productoOptional.get();
					productoBean.setTitulo(producto.getTitulo());
					productoBean.setPrecio(producto.getPrecio());
					productoBean.setTipoProducto(producto.getTipoProducto());
				}

				session.saveOrUpdate(productoBean);
				
				// Commit data.
				session.getTransaction().commit();
			}catch (ConstraintViolationException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				throw new DuplicateException(e.getCause().getMessage(),e);
			} catch (Exception e) {
				e.printStackTrace();
				// Rollback in case of an error occurred.
				session.getTransaction().rollback();
				throw new GenericExeption(e.getMessage(),e);
			}finally {
				session.close();
			}
			return producto;
		} catch (DuplicateException e) {
			throw new GenericExeption(e.getMessage(), e);
		}
	}

	public Producto deleteProducto(String codigoProducto) throws GenericExeption {
		Producto producto = getProducto(codigoProducto);

		Session session = factory.getCurrentSession();

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();
			
			session.remove(producto);
			
			// Commit data.
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(),e);
		}finally {
			session.close();
		}
		return producto;
	}

	@Override
	public List<TipoProducto> findTipoProductos() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<TipoProducto> tipoProductos = new ArrayList<TipoProducto>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + TipoProducto.class.getName() + " e ";

			// Create Query object.
			Query<TipoProducto> query = session.createQuery(sql);

			// Execute query.
			tipoProductos = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return tipoProductos;
	}
	
	@Override
	public List<Producto> findByDescripcion(String desripcion) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Producto> productos = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Producto.class.getName() + " e where UPPER(e.descripcion) like :descripcion";

			// Create Query object.
			Query<Producto> query = session.createQuery(sql);

			query.setParameter("descripcion", "%"+desripcion.toUpperCase()+"%");
			
			// Execute query.
			productos = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return productos;
	}
}
