package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;



public class CommonServiceImpl<E,R extends CrudRepository<E,Long>> implements CommonService<E> {

	
	@Autowired
	protected R alumnoRepository; //protected para que se pueda reutilizar en las clases hijas que hereden
	
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
