package demo_api.aluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_api.aluno.model.Aluno;
import demo_api.aluno.model.AlunoRepository;

@Service // Indica ao Spring que essa será uma classe de serviço
public class AlunoService {

    // Injeta a classe Repository no código para execução das operações de banco de dados
    @Autowired
    private AlunoRepository alunoRepository;

    // Salva um aluno no banco de dados
    public void save(Aluno a) {

        alunoRepository.save(a);
    }

    // Recupera todos os registros da tabela aluno
    public Iterable<Aluno> getAll() {

        return alunoRepository.findAll();
    }

}
