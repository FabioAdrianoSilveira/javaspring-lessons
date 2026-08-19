package demo_api.aluno.dto;

import demo_api.aluno.model.Aluno;

// Entidade utiizada para transportar dados no código sem expor diretamente a classe Aluno do model
public record AlunoDTO(int id, String nome, String email) {

    // Converte um objeto Aluno para um objeto AlunoDTO e retorna o objeto convertido
	public static AlunoDTO from(Aluno a) {
		
		AlunoDTO dto = new AlunoDTO(a.getId(), a.getNome(), a.getEmail());
		
		return dto;
	}

}