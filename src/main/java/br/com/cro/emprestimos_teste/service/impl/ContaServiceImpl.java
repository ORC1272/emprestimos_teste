package br.com.cro.emprestimos_teste.service.impl;


import br.com.cro.emprestimos_teste.Dto.ContaDto;
import br.com.cro.emprestimos_teste.exception.ResourceNotFoundException;
import br.com.cro.emprestimos_teste.model.Conta;
import br.com.cro.emprestimos_teste.repository.ContaRepository;
import br.com.cro.emprestimos_teste.service.ContaService;
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
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;
    private final ModelMapper modelMapper;


    @Override
    public ContaDto createConta(ContaDto contaDto) {
        Conta conta = this.modelMapper.map(contaDto, Conta.class);
        Conta newConta = this.contaRepository.save(conta);

        return this.modelMapper.map(newConta,ContaDto.class);
    }

    @Override
    public ContaDto updateConta(ContaDto contaDto, UUID id) {
        Conta conta = this.contaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Conta", "conta id", id));
        conta.setAgenciaNumero(conta.getAgenciaNumero());
        conta.setNumeroContaSemDigito(conta.getNumeroContaSemDigito());
        conta.setNumeroDigitoConta(conta.getNumeroDigitoConta());
        conta.setSegmentoConta(conta.getSegmentoConta());
        conta.setTipoLimite(conta.getTipoLimite());
        conta.setTipoBloqueio(conta.getTipoBloqueio());
        this.contaRepository.save(conta);
        //Conta contanew =this.modelMapper.map(contaDto, Conta.class);
//        Conta conta = this.contaRepository.save(conta);
        return this.modelMapper.map(conta, ContaDto.class);
    }

    @Override
    public void deleteConta(UUID id) {
        this.contaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Conta", "conta id", id));
        this.contaRepository.deleteById(id);
    }

    @Override
    public ContaDto getClienteById(UUID id) {
        Conta conta = this.contaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Conta", "conta id", id));
        return this.modelMapper.map(conta, ContaDto.class);

    }

    @Override
    public List<ContaDto> getAllContaDto() {
        List<Conta> contaList = this.contaRepository.findAll();
        List<ContaDto> contaDtoList = contaList.stream()
                .map((conta)-> this.modelMapper.map(conta, ContaDto.class)).collect(Collectors.toList());
        return contaDtoList;
    }


}
