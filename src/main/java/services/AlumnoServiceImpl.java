package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AlumnoServiceImpl<E,R extends CrudRepository<E,Long>> implements AlumnoService<E> {

	
	@Autowired
	private R alumnoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> buscarTodos() {
		return alumnoRepository.findAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> buscarPorId(Long id) {
		return alumnoRepository.findById(id);
	}

	@Override
	@Transactional
	public E guardar(E entity) {
		return alumnoRepository.save(entity);
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) {
		alumnoRepository.deleteById(id);
		
	}

}
