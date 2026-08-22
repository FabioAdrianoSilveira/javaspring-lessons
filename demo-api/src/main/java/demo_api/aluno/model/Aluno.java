package demo_api.aluno.model;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indica ao hibernate que essa classe corresponderá a uma tabela do banco
public class Aluno {
    @Id // Marca o atributo abaixo como a PRIMARY KEY da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) // Define que o atributo abaixo deve ser gerado automaticamente
    private @Nullable Integer id; // @Nullable indica que o valor do atributo pode ser nulo
    private String nome;
    private String email;

    public Aluno() {}

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
