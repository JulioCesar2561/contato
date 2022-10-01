package br.com.curso.contato.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 100)
    private String nome;
    @Column(name = "telefone", length = 50)
    private String telefone;
    @Column(name = "email", length = 200, unique = true)
    private String email;
    @Column(name = "idade")
    private Integer idade;
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pessoa")
    private List<Endereco> enderecos;

    public Pessoa(){

    }

    public Pessoa(String nome, String telefone, String email, Integer idade, List<Endereco> enderecos) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
        this.enderecos = enderecos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
