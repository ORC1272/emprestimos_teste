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


    private final ModelMapper modelMapper;
    private final ClienteRepository clienteRepository;


    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
//        Conta conta = this.contaRepository.findById(contaId)
//                .orElseThrow(()-> new ResourceNotFoundException("Conta", "Conta id", contaId));
        Cliente cliente = this.modelMapper.map(clienteDto, Cliente.class);
        Cliente newCliente = this.clienteRepository.save(cliente);
        return this.modelMapper.map(newCliente, ClienteDto.class);

    }

    @Override
    public ClienteDto updateCliente(ClienteDto clienteDto, UUID clienteId) {
        Cliente cliente = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "cliente id", clienteId));
        Cliente updateCliente = this.clienteRepository.save(cliente);
        return this.modelMapper.map(updateCliente, ClienteDto.class);
    }

    @Override
    public void deleteCliente(UUID clienteId) {
        Cliente cliente = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "cliente id", clienteId));
        this.clienteRepository.deleteById(clienteId);

    }

    @Override
    public List<ClienteDto> getAllClienteDto() {
        List<Cliente> clienteList = (List<Cliente>) this.clienteRepository.findAll();
        List<ClienteDto> clienteDtoList = clienteList.stream()
                .map((cliente) -> this.modelMapper.map(cliente, ClienteDto.class)).collect(Collectors.toList());
        return clienteDtoList;
    }

    @Override
    public ClienteDto getClienteById (UUID clienteId){
        Cliente cliente = this.clienteRepository.findById(clienteId)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente", "cliente id", clienteId));
        return this.modelMapper.map(cliente, ClienteDto.class);
    }



}

