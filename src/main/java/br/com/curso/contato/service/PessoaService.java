package br.com.curso.contato.service;

import br.com.curso.contato.dto.PessoaDTO;
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
            pessoaDTO.setEnderecosDTO(enderecoService.listaEndereco(pessoaList.get(x).getId()));

            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

}
