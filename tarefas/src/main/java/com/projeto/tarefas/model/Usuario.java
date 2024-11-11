package com.projeto.tarefas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.tarefas.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String telefone;

    @JsonIgnore
    @DBRef
    private List<Tarefa> tarefas;

    public static Usuario fromDto(UsuarioDto usuarioDto){
        return new Usuario(null, usuarioDto.nome(), usuarioDto.email(), usuarioDto.telefone(), usuarioDto.tarefas());
    }
}
