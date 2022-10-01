package br.com.curso.contato.service;


import br.com.curso.contato.dto.EnderecoDTO;
import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.model.Endereco;
import br.com.curso.contato.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<EnderecoDTO> listaEndereco(Integer idPessoa){
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        List<EnderecoDTO> enderecoListaDTO = new ArrayList<>();
        List<Endereco> enderecoLista = enderecoRepository.findAll();

        for(Integer x = 0; x < enderecoLista.size(); x++){

            if (idPessoa == enderecoLista.get(x).getPessoa().getId()){

                enderecoDTO.setId(enderecoLista.get(x).getId());
                enderecoDTO.setLogradouro(enderecoLista.get(x).getLogradouro());
                //enderecoDTO.setPessoaDTO

                enderecoListaDTO.add(enderecoDTO);
            }

        }

        return enderecoListaDTO;
    }

}