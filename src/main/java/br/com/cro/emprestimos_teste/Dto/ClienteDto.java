package br.com.cro.emprestimos_teste.Dto;

import br.com.cro.emprestimos_teste.model.Conta;
import br.com.cro.emprestimos_teste.model.TipoConta;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto {

    private UUID clienteId;
    private @NotBlank String cpf;
    private @NotBlank String email;
    private @NotBlank String nomeCompleto;
    private @NotBlank String telefone;
    private @NotBlank TipoConta tipoConta;
    private @NotBlank ContaDto conta;


}
