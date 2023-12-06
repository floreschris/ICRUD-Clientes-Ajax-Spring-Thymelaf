package com.soluciones.interfaceService;

import java.util.List;
import java.util.Optional;

import com.soluciones.modelo.Cliente;

public interface IClienteService {
	public List<Cliente> listar();

	public Optional<Cliente> listarId(int id);

	public int save(Cliente c);

	public void delete(int id);
}
