package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IPiezaDAO;
import mainApp.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService{

	@Autowired
	IPiezaDAO iPiezaDAO;
	
	@Override
	public List<Pieza> listarPiezas() {
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza piezaId(int id) {
		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void eliminarPieza(int id) {
		iPiezaDAO.deleteById(id);
	}
	
}
