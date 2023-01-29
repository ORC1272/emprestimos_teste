package br.com.cro.emprestimos_teste.service;

import br.com.cro.emprestimos_teste.Dto.ClienteDto;
import br.com.cro.emprestimos_teste.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
public interface ClienteService {

    ClienteDto createCliente(ClienteDto clienteDto);

    ClienteDto updateCliente(ClienteDto cliente, UUID id);

    ClienteDto getClienteById(UUID id);
    List<ClienteDto> getAllClientes();
    void deleteCliente(UUID id);

}
