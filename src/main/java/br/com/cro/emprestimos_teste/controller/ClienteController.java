package br.com.cro.emprestimos_teste.controller;

import br.com.cro.emprestimos_teste.Dto.ClienteDto;
import br.com.cro.emprestimos_teste.model.ApiResponse;
import br.com.cro.emprestimos_teste.service.ClienteService;
import br.com.cro.emprestimos_teste.service.ContaService;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @PutMapping("/clientes/{id}")

    public ResponseEntity<ClienteDto> upgradeCliente(
            @RequestBody ClienteDto clienteDto,
            @PathVariable UUID id) {
        ClienteDto updateCliente = this.clienteService.updateCliente(clienteDto, id);
        return new ResponseEntity<ClienteDto>(updateCliente, HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")

    public ApiResponse deleteCliente(@PathVariable UUID id){
        this.clienteService.deleteCliente(id);
        return new ApiResponse("cliente deleteado com sucesso", true);
    }

    @GetMapping("/clientes/{id}")

    public ResponseEntity<ClienteDto> getClienteById(@PathVariable UUID id){
        ClienteDto clienteDto = this.clienteService.getClienteById(id);
        return new ResponseEntity<ClienteDto>(clienteDto, HttpStatus.OK);
    }

    @GetMapping("/clientes")

    public ResponseEntity<List<ClienteDto>> getAllClientes(){
        List<ClienteDto> clienteDtoList = this.clienteService.getAllClientes();
        return ResponseEntity.ok(clienteDtoList);
    }

}
