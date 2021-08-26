package mainApp.service;

import java.util.List;

import mainApp.dto.Proveedor;

public interface IProveedorService {

	public List<Proveedor> listarProveedor(); // Listar todos los proveedores
	
	public Proveedor guardarProveedor(Proveedor proveedor); // Guardar un proveedor CREATE
	
	public Proveedor proveedorId(int id); // Leer datos de un proveedor READ
	
	public Proveedor actualizarProveedor(Proveedor proveedor); // Actualizar datos de un proveedor UPDATE
	
	public void eliminarProveedor(int id); // Elimina un proveedor DELETE
	
}
