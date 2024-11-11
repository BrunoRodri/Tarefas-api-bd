package com.projeto.tarefas.dto;

import com.projeto.tarefas.model.Tarefa;
import com.projeto.tarefas.model.Usuario;

public record TarefaDto(
        String id,
        String titulo,
        String descricao,
        String data_criacao,
        String prioridade,
        Usuario usuario
) {
    public TarefaDto(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getData_criacao(), tarefa.getPrioridade(), tarefa.getUsuario());
    }

}
