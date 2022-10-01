package br.com.curso.contato.dto;

public class EnderecoDTO {

    private Integer id;
    private PessoaDTO pessoaDTO;
    private String logradouro;

    public EnderecoDTO(){

    }

    public EnderecoDTO(PessoaDTO pessoaDTO, String logradouro) {
        this.pessoaDTO = pessoaDTO;
        this.logradouro = logradouro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PessoaDTO getPessoaDTO() {
        return pessoaDTO;
    }

    public void setPessoaDTO(PessoaDTO pessoaDTO) {
        this.pessoaDTO = pessoaDTO;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
