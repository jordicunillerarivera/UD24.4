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

import mainApp.dto.Pieza;
import mainApp.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarCPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/piezas/{id}")
	public Pieza PiezaId(@PathVariable(name="id") int id) {
		
		Pieza Pieza_xid= new Pieza();
		
		Pieza_xid=piezaServiceImpl.piezaId(id);
		
		System.out.println("Pieza ID: "+Pieza_xid);
		
		return Pieza_xid;
	}
	
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int id,@RequestBody Pieza pieza) {
		
		Pieza Pieza_seleccionado= new Pieza();
		Pieza Pieza_actualizado= new Pieza();
		
		Pieza_seleccionado= piezaServiceImpl.piezaId(id);
		
		Pieza_seleccionado.setNombre(pieza.getNombre());
		
		Pieza_actualizado = piezaServiceImpl.actualizarPieza(Pieza_seleccionado);
		
		System.out.println("El Pieza actualizado es: "+ Pieza_actualizado);
		
		return Pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		piezaServiceImpl.eliminarPieza(id);
	}

}
