package mainApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="codigoPieza")
	Pieza pieza;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	Proveedor proveedor;
	
	@Column(name="precio")
	private int precio;
	
	// Constructores
	public Suministra() {
		
	}
	
	public Suministra(int id, Pieza pieza, Proveedor proveedor, int precio) {
		super();
		this.id = id;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
	}

	// Setters & Getters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Suministra [pieza=" + pieza + ", proveedor=" + proveedor + ", precio=" + precio + "]";
	}
	
}
