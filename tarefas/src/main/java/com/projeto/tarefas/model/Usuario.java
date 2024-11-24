package com.projeto.tarefas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.tarefas.dto.UsuarioDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "O nome não pode ser nulo.")
    private String nome;
    @NotBlank(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.")
    private String email;
    @NotBlank(message = "O telefone não pode ser nulo.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos.")
    private String telefone;

    @JsonIgnore
    @DBRef
    private List<Tarefa> tarefas;

    public static Usuario fromDto(UsuarioDto usuarioDto){
        return new Usuario(null, usuarioDto.nome(), usuarioDto.email(),
                usuarioDto.telefone(), usuarioDto.tarefas());
    }
}
