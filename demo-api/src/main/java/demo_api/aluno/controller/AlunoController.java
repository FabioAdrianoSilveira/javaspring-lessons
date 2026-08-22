package demo_api.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo_api.aluno.service.AlunoService;
import demo_api.aluno.dto.AlunoDTO;
import demo_api.aluno.model.Aluno;

@RequestMapping(path = "/demo-api") // Define o endpoint base para todas as rotas da classe
/*
 * @RestController define que a classe é um controller REST. Todo retorno de
 * método será serializado automaticamente para JSON no corpo da resposta HTTP.
 */
@RestController
public class AlunoController {

    // Injeta a camada de serviço no código para execução das regras de negócio
    @Autowired
    private AlunoService alunoService;

    
    @PostMapping("/alunoString") // Define endpoint do tipo POST
    public ResponseEntity<AlunoDTO> createString(@RequestParam String nome, @RequestParam String email) {
        // @RequestParam captura parâmetros passados pela URL ou via formulários
        try {
            // Instancia um aluno e salva no banco com o método save()
            Aluno a = new Aluno(nome, email);
            alunoService.save(a);
            
            //Retorna um DTO com o status HTTP 201 (CREATED)
            return new ResponseEntity<>(AlunoDTO.from(a), HttpStatus.CREATED);
        } catch (Exception e) {
            //Retorna o status HTTP 500 (INTERNAL_SERVER_ERROR) em caso de erro no POST
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/alunos") //Define endpoint do tipo GET
    public @ResponseBody Iterable<Aluno> getAll() {
        // Retorna um JSON com todos os registros da tabela Aluno
        return alunoService.getAll();
    }
}