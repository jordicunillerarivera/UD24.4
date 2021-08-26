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

import mainApp.dto.Suministra;
import mainApp.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministra")
	public List<Suministra> listarSuministra(){
		return suministraServiceImpl.listarSuministra();
	}
	
	
	@PostMapping("/suministra")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {
		
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	
	@GetMapping("/suministra/{id}")
	public Suministra suministraId(@PathVariable(name="id") int id) {
		
		Suministra Suministra_xid= new Suministra();
		
		Suministra_xid=suministraServiceImpl.suministraId(id);
		
		System.out.println("Suministra ID: "+Suministra_xid);
		
		return Suministra_xid;
	}
	
	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")int id,@RequestBody Suministra suministra) {
		
		Suministra Suministra_seleccionado= new Suministra();
		Suministra Suministra_actualizado= new Suministra();
		
		Suministra_seleccionado= suministraServiceImpl.suministraId(id);
		
		Suministra_seleccionado.setPieza(suministra.getPieza());
		
		Suministra_seleccionado.setProveedor(suministra.getProveedor());
		
		Suministra_seleccionado.setPrecio(suministra.getPrecio());
		
		Suministra_actualizado = suministraServiceImpl.actualizarSuministra(Suministra_seleccionado);
		
		System.out.println("El Pieza actualizado es: "+ Suministra_actualizado);
		
		return Suministra_actualizado;
	}
	
	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name="id")int id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
	
}
