package services;

import java.util.Optional;



public interface CommonService<E> {

	public Iterable<E> buscarTodos();
	public Optional<E> buscarPorId(Long id);
	public E guardar(E entity);
	public void eliminarPorId(Long id);
}
