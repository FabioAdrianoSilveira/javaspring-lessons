package demo_api.aluno.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.jspecify.annotations.Nullable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

// Uso da biblioteca lombok para remoção de boilerplates (torna a criação manual de getters e setters desnecessária)
@Getter
@Setter

@Entity // Indica ao hibernate que essa classe corresponderá a uma tabela do banco
public class Aluno {
    @Id // Marca o atributo abaixo como a PRIMARY KEY da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) // Define que o atributo abaixo deve ser gerado automaticamente
    private @Nullable Integer id; // @Nullable indica que o valor do atributo pode ser nulo

    @NotBlank(message = "O nome do aluno é obrigatório!")
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    @Past
    private LocalDate dtNasc;
    @NotNull
    private Boolean ativo;
    @NotNull
    @Positive
    private float altura;

    public Aluno() {
    }

    public Aluno(String nome, String email, String cpf, LocalDate dtNasc, Boolean ativo, float altura) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.ativo = ativo;
        this.altura = altura;
    }
}
