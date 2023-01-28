package br.com.cro.emprestimos_teste.controller;

import br.com.cro.emprestimos_teste.Dto.ContaDto;
import br.com.cro.emprestimos_teste.model.ApiResponse;
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
public class ContaController {
    private final ContaService contaService;

    @PostMapping("/contas")
    public ResponseEntity<ContaDto> createConta(
            @RequestBody ContaDto contaDto){
            ContaDto createConta=this.contaService.createConta(contaDto);
            return new ResponseEntity<ContaDto>(createConta, HttpStatus.CREATED);

    }

    @PutMapping("/contas/{contaId}")
    public ResponseEntity<ContaDto> updateConta(
            @RequestBody ContaDto contaDto,
            @PathVariable UUID contaID){
        ContaDto updateConta = this.contaService.updateConta(contaDto, contaID);
        return new ResponseEntity<ContaDto>(updateConta, HttpStatus.CREATED);

    }

    @DeleteMapping("/contas/{contaId}")
    public ApiResponse deleteConta(@PathVariable UUID contaID){
        this.contaService.deleteConta(contaID);
        return new ApiResponse("conta deletada com sucesso", true);
    }

    @GetMapping("/contas/{contaId}")

    public ResponseEntity<ContaDto> getClienteId(@PathVariable UUID ContaId){
        ContaDto contaDto = this.contaService.getClienteById(ContaId);
        return new ResponseEntity<ContaDto>(contaDto, HttpStatus.OK);
    }

    @GetMapping("/contas")

    public ResponseEntity<List<ContaDto>> getAllContaDto(){
        List<ContaDto> contaDtoList = this.contaService.getAllContaDto();
        return ResponseEntity.ok(contaDtoList);
    }


}
