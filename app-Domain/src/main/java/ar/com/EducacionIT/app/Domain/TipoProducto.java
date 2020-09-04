package ar.com.EducacionIT.app.Domain;

public class TipoProducto {
private Long id;
private String descripcion;

public TipoProducto() {
	// TODO Auto-generated constructor stub
}

public TipoProducto(Long id, String descripcion) {
	super();
	this.id = id;
	this.descripcion = descripcion;
}

@Override
public String toString() {
	return "tipoProducto [id=" + id + ", descripcion=" + descripcion + "]";
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

}

