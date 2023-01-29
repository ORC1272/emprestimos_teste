package br.com.cro.emprestimos_teste.service;

import br.com.cro.emprestimos_teste.Dto.ContaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ContaService {

    ContaDto createConta(ContaDto contaDto);

    ContaDto updateConta(ContaDto contaDto, UUID id);

    void deleteConta(UUID id);

    ContaDto getClienteById(UUID id);

    List<ContaDto> getAllContaDto();
}
