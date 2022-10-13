package br.com.curso.contato.repository;

import br.com.curso.contato.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT e FROM Pessoa e WHERE e.nome like :name")
    List<Pessoa> findByNomePessoa (String name);

}
