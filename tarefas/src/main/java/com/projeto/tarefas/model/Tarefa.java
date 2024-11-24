package com.projeto.tarefas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.tarefas.Enums.Prioridade;
import com.projeto.tarefas.dto.TarefaDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "O título não pode estar Nulo.")
    private String titulo;
    @NotBlank(message = "A descrição não pode estar Nula.")
    private String descricao;
    @NotNull(message = "Preencher a data de criação.")
    private LocalDate data_criacao;
    @NotNull(message = "Preencher a prioridade.")
    Prioridade prioridade;

    @JsonIgnore
    @DBRef
    private Usuario usuario;

    private boolean isDeleted = false;

    public static Tarefa fromDto(TarefaDto tarefaDto){
        return new Tarefa(null, tarefaDto.titulo(), tarefaDto.descricao(),
                tarefaDto.data_criacao(), tarefaDto.prioridade(), tarefaDto.usuario(), false);
    }
}
