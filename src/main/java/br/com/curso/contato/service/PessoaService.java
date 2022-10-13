package br.com.curso.contato.service;

import br.com.curso.contato.dto.EnderecoDTO;
import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.model.Endereco;
import br.com.curso.contato.model.Pessoa;
import br.com.curso.contato.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    EnderecoService enderecoService;

    public List<PessoaDTO> listarPessoas(){

        List<PessoaDTO> pessoaDTOList = new ArrayList<>();
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList =  pessoaRepository.findAll();

        for (Integer x=0; x < pessoaList.size(); x++){
            PessoaDTO pessoaDTO = new PessoaDTO();

            pessoaDTO.setId(pessoaList.get(x).getId());
            pessoaDTO.setEmail(pessoaList.get(x).getEmail());
            pessoaDTO.setNome(pessoaList.get(x).getNome());
            pessoaDTO.setIdade(pessoaList.get(x).getIdade());
            pessoaDTO.setTelefone(pessoaList.get(x).getTelefone());

            List<EnderecoDTO> enderecoDTOList =new ArrayList<>();

            for (Endereco endereco : pessoaList.get(x).getEnderecos()){

                EnderecoDTO enderecoDTO = new EnderecoDTO();

                //enderecoDTO.setPessoaDTO(pessoaDTO); O DTO NÁO RECONHECE POR ISSO NÃO É IMPLEMENTADO
                enderecoDTO.setLogradouro(endereco.getLogradouro());
                enderecoDTO.setId(endereco.getId());
                enderecoDTOList.add(enderecoDTO);
                pessoaDTO.setEnderecosDTO(enderecoDTOList);
            }

            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

    public PessoaDTO salvar(PessoaDTO pessoaDTO){

        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setIdade(pessoaDTO.getId());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        pessoa.setIdade(pessoaDTO.getIdade());

        List<Endereco> enderecoList = new ArrayList<>();

        for (EnderecoDTO enderecoDTO : pessoaDTO.getEnderecosDTO()){
            Endereco endereco = new Endereco();
            endereco.setPessoa(pessoa);
            endereco.setLogradouro(enderecoDTO.getLogradouro());
            enderecoList.add(endereco);
            pessoa.setEnderecos(enderecoList);
        }

        Pessoa pessoaRetornada = pessoaRepository.save(pessoa);

        return pessoaDTO;

    }

    public PessoaDTO consultarId(Integer id){

        PessoaDTO pessoaDTO = new PessoaDTO();
        Pessoa pessoa;

        pessoa = pessoaRepository.findById(id).get();

        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setEmail(pessoa.getEmail());
        pessoaDTO.setTelefone(pessoa.getEmail());
        pessoaDTO.setIdade(pessoa.getIdade());

        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();

        for (Endereco endereco : pessoa.getEnderecos()){

            EnderecoDTO enderecoDTO = new EnderecoDTO();

            enderecoDTO.setId(endereco.getId());
            enderecoDTO.setLogradouro(endereco.getLogradouro());

            enderecoDTOList.add(enderecoDTO);
        }

        pessoaDTO.setEnderecosDTO(enderecoDTOList);

        return pessoaDTO;
    }

    public List<PessoaDTO> consultarNome(String nome){

        List<PessoaDTO> pessoaDTOList = new ArrayList<>();
        List<Pessoa> pessoaList = new ArrayList<>();

        nome = "%" + nome + "%";
        pessoaList =  pessoaRepository.findByNomePessoa(nome);

        for (Integer x=0; x < pessoaList.size(); x++){
            PessoaDTO pessoaDTO = new PessoaDTO();

            pessoaDTO.setId(pessoaList.get(x).getId());
            pessoaDTO.setEmail(pessoaList.get(x).getEmail());
            pessoaDTO.setNome(pessoaList.get(x).getNome());
            pessoaDTO.setIdade(pessoaList.get(x).getIdade());
            pessoaDTO.setTelefone(pessoaList.get(x).getTelefone());

            List<EnderecoDTO> enderecoDTOList =new ArrayList<>();

            for (Endereco endereco : pessoaList.get(x).getEnderecos()){

                EnderecoDTO enderecoDTO = new EnderecoDTO();

                enderecoDTO.setLogradouro(endereco.getLogradouro());
                enderecoDTO.setId(endereco.getId());
                enderecoDTOList.add(enderecoDTO);
                pessoaDTO.setEnderecosDTO(enderecoDTOList);
            }

            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

}
