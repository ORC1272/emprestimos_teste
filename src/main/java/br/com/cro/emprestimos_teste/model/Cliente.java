package br.com.cro.emprestimos_teste.model;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;


@Entity
@NoArgsConstructor
@Table(name="clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;


    @Column(
            name="cpf", nullable = false
    )
    @CPF(message = "Número CPF inválido")
    private String cpf;

    @Column(
            name="email", nullable = false
    )
    @Email(message = "Email inválido")
    private String email;

    @Column(
            name="nome_completo", nullable = false
    )
    private String nomeCompleto;
    @Column(
            name="telefone", nullable = false
    )
    private String telefone;
    @Column(
            name="tipo_conta", nullable = false
    )
    private TipoConta tipoConta;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Conta conta;



//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//	private Set<Conta> contas = new HashSet<>();

//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Conta> contaList = new ArrayList<>();


//    @OneToMany(mappedBy = "idCliente",cascade = CascadeType.ALL)
//    private Set<Conta> contas=new HashSet<>();

//    @OneToMany(mappedBy = "mCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Collection<Conta> contas;

//    @ManyToOne(cascade=CascadeType.ALL)
//    private Conta conta;

//    private List<Conta> contaList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Conta> contaList = new ArrayList<>();

//    @ManyToOne(cascade=CascadeType.PERSIST)
//    @JoinColumn(name= "conta_id")
//    private Conta conta;

//    @ManyToOne (cascade=CascadeType.PERSIST)

}
