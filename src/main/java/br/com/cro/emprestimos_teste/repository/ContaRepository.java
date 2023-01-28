package br.com.cro.emprestimos_teste.repository;

import br.com.cro.emprestimos_teste.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID> {
}
