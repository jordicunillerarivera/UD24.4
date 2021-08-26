package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="piezas")
public class Pieza {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Suministra> suministra;
	
	// Constructor
	
	public Pieza() {
		
	}
	
	public Pieza(int codigo, String nombre, List<Suministra> suministra) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.suministra = suministra;
	}



	// Setters & Getters



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministra() {
		return suministra;
	}



	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}



	@Override
	public String toString() {
		return "Pieza [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
