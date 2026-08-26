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

@Entity // Indica ao hibernate que essa classe corresponderá a uma tabela do banco
public class Aluno {
    @Id // Marca o atributo abaixo como a PRIMARY KEY da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) // Define que o atributo abaixo deve ser gerado automaticamente
    private @Nullable Integer id; // @Nullable indica que o valor do atributo pode ser nulo

    @NotBlank (message = "O nome do aluno é obrigatório!")
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @CPF
    private String cpf;
    @NotNull @Past
    private LocalDate dtNasc;
    @NotNull
    private Boolean ativo;
    @NotNull @Positive
    private float altura;

    public Aluno() {}

    public Aluno(String nome, String email, String cpf, LocalDate dtNasc, Boolean ativo, float altura) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.ativo = ativo;
        this.altura = altura;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
