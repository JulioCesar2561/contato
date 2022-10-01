package br.com.curso.contato.controller;

import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String status(){

        return "<!DOCTYPE html>\n" +
                "<html lang=\"pt-br\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Status Servidor \uD83D\uDE1C</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "        <header>\n" +
                "            <h1>Ligadão</h1>\n" +
                "        </header>\n" +
                "        <main>\n" +
                "            <section class=\"Introdução\">\n" +
                "                <p>Programa embarco java, spring initializr, maven, H2 Banco de Dados </p>\n" +
                "            </section>\n" +
                "        </main>\n" +
                "        <footer>\n" +
                "            <p>\n" +
                "                <a href=\"http://localhost:8080/pessoa/consultar\">Clique aqui para ver as pessoas cadastradas</a>\n" +
                "            </p>\n" +
                "        </footer>\n" +
                "</body>\n" +
                "</html>   ";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<PessoaDTO> listar(){
        return pessoaService.listarPessoas();
    }

}

