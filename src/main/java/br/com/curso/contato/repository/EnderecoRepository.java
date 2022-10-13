package br.com.curso.contato.repository;

import br.com.curso.contato.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :idPessoa")
    List<Endereco> findByIdPessoa(Integer idPessoa);

}
