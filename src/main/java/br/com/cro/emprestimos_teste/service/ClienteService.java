package br.com.cro.emprestimos_teste.service;

import br.com.cro.emprestimos_teste.Dto.ClienteDto;
import br.com.cro.emprestimos_teste.model.Cliente;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;



@Service
public interface ClienteService {
    @Transactional
    ClienteDto createCliente(ClienteDto clienteDto);
    @Transactional
    ClienteDto updateCliente(ClienteDto clienteDto, UUID clienteId);
    @Transactional
    void deleteCliente(UUID clienteId);

    List<ClienteDto> getAllClienteDto();

    ClienteDto getClienteById(UUID clienteDtoId);


}
