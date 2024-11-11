package com.projeto.tarefas.dto;

import com.projeto.tarefas.model.Tarefa;
import com.projeto.tarefas.model.Usuario;

import java.util.List;

public record UsuarioDto(
        String id,
        String nome,
        String email,
        String telefone,
        List<Tarefa> tarefas
) {
    public UsuarioDto(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getTarefas());

    }
}
