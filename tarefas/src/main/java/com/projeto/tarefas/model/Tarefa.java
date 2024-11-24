package com.projeto.tarefas.model;

import com.projeto.tarefas.Enums.Prioridade;
import com.projeto.tarefas.dto.TarefaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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
    private LocalDate data_criacao;
    Prioridade prioridade;

    @DBRef
    private Usuario usuario;

    public static Tarefa fromDto(TarefaDto tarefaDto){
        return new Tarefa(null, tarefaDto.titulo(), tarefaDto.descricao(), tarefaDto.data_criacao(), tarefaDto.prioridade(), tarefaDto.usuario());
    }
}
