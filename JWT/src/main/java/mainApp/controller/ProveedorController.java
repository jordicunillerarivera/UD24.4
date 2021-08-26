package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Proveedor;
import mainApp.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarCPiezas(){
		return proveedorServiceImpl.listarProveedor();
	}
	
	
	@PostMapping("/proveedores")
	public Proveedor salvarPieza(@RequestBody Proveedor proveedor) {
		
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	
	@GetMapping("/proveedores/{id}")
	public Proveedor PiezaId(@PathVariable(name="id") int id) {
		
		Proveedor Pieza_xid= new Proveedor();
		
		Pieza_xid=proveedorServiceImpl.proveedorId(id);
		
		System.out.println("Pieza ID: "+Pieza_xid);
		
		return Pieza_xid;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")int id,@RequestBody Proveedor proveedor) {
		
		Proveedor Proveedor_seleccionado= new Proveedor();
		Proveedor Proveedor_actualizado= new Proveedor();
		
		Proveedor_seleccionado= proveedorServiceImpl.proveedorId(id);
		
		Proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		Proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(Proveedor_seleccionado);
		
		System.out.println("El Pieza actualizado es: "+ Proveedor_actualizado);
		
		return Proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}

}
