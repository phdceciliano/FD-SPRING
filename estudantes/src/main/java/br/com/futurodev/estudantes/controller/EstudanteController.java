package br.com.futurodev.estudantes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    // Banco de dados fictício (lista em memória)
    private static final List<Estudante> estudantes = new ArrayList<>();

    // [...] outros métodos existentes (POST e GETs)

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> removerEstudante(@PathVariable String matricula) {
        Optional<Estudante> estudanteParaRemover = estudantes.stream()
                .filter(e -> e.getMatricula().equals(matricula))
                .findFirst();

        if (estudanteParaRemover.isPresent()) {
            estudantes.remove(estudanteParaRemover.get());
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

    // Classe Estudante (mantida igual)
    public static class Estudante {
        @jakarta.validation.constraints.NotBlank(message = "Nome é obrigatório")
        private String nome;

        @jakarta.validation.constraints.NotNull(message = "Idade é obrigatória")
        @jakarta.validation.constraints.Min(value = 16, message = "Idade mínima é 16 anos")
        private Integer idade;

        @jakarta.validation.constraints.NotBlank(message = "Matrícula é obrigatória")
        @jakarta.validation.constraints.Pattern(regexp = "^[A-Za-z0-9]{6,12}$",
                message = "Matrícula deve conter entre 6 e 12 caracteres alfanuméricos")
        private String matricula;

        @jakarta.validation.constraints.Email(message = "Email deve ser válido")
        private String email;

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}