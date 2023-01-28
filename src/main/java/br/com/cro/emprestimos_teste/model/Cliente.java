package br.com.cro.emprestimos_teste.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;


@Entity
@Table(name="clientes")
@Data
@NoArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID clienteId;

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

//    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL)
//	Set<Conta> contas;







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
