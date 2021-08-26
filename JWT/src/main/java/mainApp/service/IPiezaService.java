package mainApp.service;

import java.util.List;

import mainApp.dto.Pieza;

public interface IPiezaService {

	public List<Pieza> listarPiezas(); // Listar todas las piezas
	
	public Pieza guardarPieza(Pieza pieza); // Guardar una pieza CREATE
	
	public Pieza piezaId(int id); // Leer datos de una pieza READ
	
	public Pieza actualizarPieza(Pieza pieza); // Actualizar datos de la pieza UPDATE
	
	public void eliminarPieza(int id); // Elimina la pieza DELETE
	
}
