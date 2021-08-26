package mainApp.service;

import java.util.List;

import mainApp.dto.Suministra;

public interface ISuministraService {

	public List<Suministra> listarSuministra(); // Listar todos los suministras
	
	public Suministra guardarSuministra(Suministra suministra); // Guardar un suministro CREATE
	
	public Suministra suministraId(int id); // Leer datos de un suministro READ
	
	public Suministra actualizarSuministra(Suministra suministra); // Actualizar datos del suministro UPDATE
	
	public void eliminarSuministra(int id); // Elimina un suministro DELETE
	
}
