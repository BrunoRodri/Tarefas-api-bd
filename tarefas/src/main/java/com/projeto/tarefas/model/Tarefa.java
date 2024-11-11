package com.projeto.tarefas.model;

import com.projeto.tarefas.dto.TarefaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "tarefas")
public class Tarefa {

    @Id
    private String id;
    private String titulo;
    private String descricao;
    private String data_criacao;
    private String prioridade;

    @DBRef
    private Usuario usuario;

    public static Tarefa fromDto(TarefaDto tarefaDto){
        return new Tarefa(null, tarefaDto.titulo(), tarefaDto.descricao(), tarefaDto.data_criacao(), tarefaDto.prioridade(), tarefaDto.usuario());
    }
}
