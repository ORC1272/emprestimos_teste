package br.com.cro.emprestimos_teste.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;



@Entity
@NoArgsConstructor
@Table(name="contas")
@Data
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID contaId;

    private String agenciaNumero;

    @NotBlank(message = "Número da conta não informado")
    private String numeroContaSemDigito;

    @NotBlank(message = "Digito da conta não informado")
    private String numeroDigitoConta;

    private SegmentoConta segmentoConta;

    private TipoLimite tipoLimite;

    private TipoBloqueio tipoBloqueio;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "cliente_id", nullable = false)
//    Cliente cliente;





//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn (name="conta_id",referencedColumnName="id",nullable=false,unique=true)
//    private Cliente mCliente;

//    @OneToMany(mappedBy = "conta",cascade = CascadeType.ALL)
//    private Set<Comment> comments=new HashSet<>();


//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "cliente_id")
//    private Cliente cliente;

//    @JsonIgnore
//    @OneToMany(cascade=CascadeType.ALL)
//    private Cliente cliente;

//        @JsonIgnore
//    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Cliente> cliente=new ArrayList<>();


}
