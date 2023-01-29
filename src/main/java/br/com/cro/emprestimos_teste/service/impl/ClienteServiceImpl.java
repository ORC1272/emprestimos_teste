package br.com.cro.emprestimos_teste.service.impl;

import br.com.cro.emprestimos_teste.Dto.ClienteDto;
import br.com.cro.emprestimos_teste.exception.ResourceNotFoundException;
import br.com.cro.emprestimos_teste.model.Cliente;
import br.com.cro.emprestimos_teste.repository.ClienteRepository;
import br.com.cro.emprestimos_teste.service.ClienteService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;


    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = this.modelMapper.map(clienteDto, Cliente.class);
        Cliente newCliente = this.clienteRepository.save(cliente);
        return this.modelMapper.map(newCliente, ClienteDto.class);

    }


    @Override
    public ClienteDto updateCliente(ClienteDto clienteDto, UUID id) {
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "cliente id", id));
        Cliente updateCliente = this.clienteRepository.save(cliente);
        return this.modelMapper.map(updateCliente, ClienteDto.class);
    }

    @Override
    public void deleteCliente(UUID id) {
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "cliente id", id));
        this.clienteRepository.delete(cliente);

    }

    @Override
    public ClienteDto getClienteById (UUID id){
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente", "cliente id", id));
        return this.modelMapper.map(cliente, ClienteDto.class);
    }

    @Override
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clienteList = this.clienteRepository.findAll();
        List<ClienteDto> clienteDtoList = clienteList.stream()
                .map((cliente) -> this.modelMapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return clienteDtoList;
    }

}

