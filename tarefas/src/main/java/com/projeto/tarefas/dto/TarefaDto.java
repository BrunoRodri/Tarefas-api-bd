package com.projeto.tarefas.dto;

import com.projeto.tarefas.Enums.Prioridade;
import com.projeto.tarefas.model.Tarefa;
import com.projeto.tarefas.model.Usuario;

import java.time.LocalDate;

public record TarefaDto(
        String id,
        String titulo,
        String descricao,
        LocalDate data_criacao,
        Prioridade prioridade,
        Usuario usuario
) {
    public TarefaDto(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getData_criacao(), tarefa.getPrioridade(), tarefa.getUsuario());
    }

}
