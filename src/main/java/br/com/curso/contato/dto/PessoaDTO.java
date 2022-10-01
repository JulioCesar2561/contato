package br.com.curso.contato.dto;

import java.util.List;

public class PessoaDTO {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private Integer idade;
    private List<EnderecoDTO> enderecosDTO;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, String telefone, String email, Integer idade, List<EnderecoDTO> enderecosDTO) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
        this.enderecosDTO = enderecosDTO;
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

    public List<EnderecoDTO> getEnderecosDTO() {
        return enderecosDTO;
    }

    public void setEnderecosDTO(List<EnderecoDTO> enderecosDTO) {
        this.enderecosDTO = enderecosDTO;
    }
}
