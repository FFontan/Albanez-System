package br.edu.umfg.teste.spring.repositories;

import br.edu.umfg.teste.spring.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findBydocumento(String documento);
}
