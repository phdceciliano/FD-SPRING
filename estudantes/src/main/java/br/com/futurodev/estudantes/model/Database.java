package br.com.futurodev.estudantes.model;
import br.com.futurodev.estudantes.Estudante;

import java.util.ArrayList;
import java.util.List;

public class Database {
    // Atributo estático que armazena a lista de estudantes
    private static final List<Estudante> estudantes = new ArrayList<>();

    // Adicionar
    public static void adicionarEstudante(Estudante estudante) {
        if (estudante != null) {
            estudantes.add(estudante);
            System.out.println("Estudante adicionado com sucesso!");
        } else {
            System.out.println("Erro: Não é possível adicionar um estudante nulo.");
        }
    }

    // Remover
    public static boolean removerEstudante(Estudante estudante) {
        if (estudante == null) {
            System.out.println("Erro: Estudante não pode ser nulo.");
            return false;
        }

        boolean removido = estudantes.remove(estudante);
        if (removido) {
            System.out.println("Estudante removido com sucesso!");
        } else {
            System.out.println("Estudante não encontrado na base de dados.");
        }
        return removido;
    }

    //Listar
    public static void listarEstudantes() {
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado na base de dados.");
            return;
        }

        System.out.println("\n=== LISTA DE ESTUDANTES ===");
        for (Estudante estudante : estudantes) {
            System.out.println(estudante);
        }
        System.out.println("==========================\n");
    }

    //buscarRegistro
    public static Estudante buscarRegistro(Integer registro) {
        if (registro == null) {
            System.out.println("Erro: Registro não pode ser nulo.");
            return null;
        }

        for (Estudante estudante : estudantes) {
            if (registro.equals(estudante.getRegistro())) {
                return estudante;
            }
        }

        System.out.println("Estudante com registro " + registro + " não encontrado.");
        return null;
    }
}