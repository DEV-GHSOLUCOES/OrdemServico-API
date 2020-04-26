package br.com.gh.os.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gh.os.domain.excepetion.NegocioExcepetion;
import br.com.gh.os.domain.model.Cliente;
import br.com.gh.os.domain.repository.ClienteRepository;


@Service
public class CadastroClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioExcepetion("Ja existe um cliente cadastrado com esse email! ");
		}
		
		return clienteRepository.save(cliente);
		 
	}
	
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
