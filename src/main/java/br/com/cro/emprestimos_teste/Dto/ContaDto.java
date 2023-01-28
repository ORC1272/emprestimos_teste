package br.com.cro.emprestimos_teste.Dto;

import br.com.cro.emprestimos_teste.model.Cliente;
import br.com.cro.emprestimos_teste.model.SegmentoConta;
import br.com.cro.emprestimos_teste.model.TipoBloqueio;
import br.com.cro.emprestimos_teste.model.TipoLimite;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class ContaDto {

    private UUID contaId;
    private @NotBlank String agenciaNumero;
    private @NotBlank String numeroContaSemDigito;
    private @NotBlank String numeroDigitoConta;
    private @NotBlank SegmentoConta segmentoConta;
    private @NotBlank TipoLimite tipoLimite;
    private @NotBlank TipoBloqueio tipoBloqueio;
    private @NotBlank Cliente cliente;
}
