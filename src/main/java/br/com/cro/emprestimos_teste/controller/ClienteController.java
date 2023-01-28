package br.com.cro.emprestimos_teste.controller;

import br.com.cro.emprestimos_teste.Dto.ClienteDto;
import br.com.cro.emprestimos_teste.Dto.ContaDto;
import br.com.cro.emprestimos_teste.model.ApiResponse;
import br.com.cro.emprestimos_teste.repository.ClienteRepository;
import br.com.cro.emprestimos_teste.service.ClienteService;
import br.com.cro.emprestimos_teste.service.ContaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private final ClienteService clienteService;

    private final ContaService contaService;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteDto> createCliente(
            @RequestBody ClienteDto clienteDto){
            ClienteDto createCliente = this.clienteService.createCliente(clienteDto);
            return new ResponseEntity<ClienteDto>(createCliente, HttpStatus.CREATED);

    }

    @PutMapping("/clientes/{clienteId}")

    public ResponseEntity<ClienteDto> upgradeCliente(
            @RequestBody ClienteDto clienteDto,
            @PathVariable UUID clienteId) {
        ClienteDto updateCliente = this.clienteService.updateCliente(clienteDto, clienteId);
        return new ResponseEntity<ClienteDto>(updateCliente, HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{clienteId}")

    public ApiResponse deleteCliente(@PathVariable UUID clienteId){
        this.clienteService.deleteCliente(clienteId);
        return new ApiResponse("cliente deleteado com sucesso", true);
    }

    @GetMapping("/clientes/{clienteId}")

    public ResponseEntity<ClienteDto> getClienteId(@PathVariable UUID clienteId){
        ClienteDto clienteDto = this.clienteService.getClienteById(clienteId);
        return new ResponseEntity<ClienteDto>(clienteDto, HttpStatus.OK);
    }

    @GetMapping("/clientes")

    public ResponseEntity<List<ClienteDto>> getAllClienteDto(){
        List<ClienteDto> clienteDtoList = this.clienteService.getAllClienteDto();
        return ResponseEntity.ok(clienteDtoList);
    }

}
