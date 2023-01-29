package br.com.cro.emprestimos_teste.Dto;
import br.com.cro.emprestimos_teste.model.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto {

    private UUID id;
    private @NotBlank String cpf;
    private @NotBlank String email;
    private @NotBlank String nomeCompleto;
    private @NotBlank String telefone;
    private @NotBlank TipoConta tipoConta;
    private @NotBlank ContaDto conta;


}
