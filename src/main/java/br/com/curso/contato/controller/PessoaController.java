package br.com.curso.contato.controller;

import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


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

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO salvar(@RequestBody PessoaDTO pessoaDTO){
        return pessoaService.salvar(pessoaDTO);
    }

    @GetMapping(value = "/consultar/id/{id}")
    public PessoaDTO consultaPorId(@PathVariable Integer id){

        if(id == 0){
            return null;
        }else {
            PessoaDTO pessoaDTOConsulta = pessoaService.consultarId(id);
            return pessoaDTOConsulta;
        }
    }

    @GetMapping(value = "/consultar/nome/{nome}")
    public List<PessoaDTO> consultaPorNome(@PathVariable String nome){

        List<PessoaDTO> pessoasConsultaNome = pessoaService.consultarNome(nome.toUpperCase());
        return pessoasConsultaNome;

    }
}

