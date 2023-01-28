package br.com.cro.emprestimos_teste.repository;
import br.com.cro.emprestimos_teste.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
//    Cliente findByCliete(Cliente cliente);


    //    List<Cliente> findByCliente(Cliente cliente);
//
//    List<Cliente> findByConta(Conta conta);
}
