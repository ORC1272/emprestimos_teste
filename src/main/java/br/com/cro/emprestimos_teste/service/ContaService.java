package br.com.cro.emprestimos_teste.service;

import br.com.cro.emprestimos_teste.Dto.ContaDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public interface ContaService {
    @Transactional
    ContaDto createConta(ContaDto contaDto);
    @Transactional
    ContaDto updateConta(ContaDto contaDto, UUID contaId);
    @Transactional
    void deleteConta(UUID contaId);

    ContaDto getClienteById(UUID contaId);

    List<ContaDto> getAllContaDto();
}
