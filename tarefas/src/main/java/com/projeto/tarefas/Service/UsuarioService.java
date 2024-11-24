package com.projeto.tarefas.Service;

import com.projeto.tarefas.dto.UsuarioDto;
import com.projeto.tarefas.model.Usuario;
import com.projeto.tarefas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Page<UsuarioDto> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable).map(UsuarioDto::new);
    }

    public UsuarioDto findById(String id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            return new UsuarioDto(optionalUsuario.get());
        }
        throw new NoSuchElementException("Usuário de ID: " + id + " não encontrado.");
    }

    public UsuarioDto save(UsuarioDto usuarioDto){
        return new UsuarioDto(usuarioRepository.save(Usuario.fromDto(usuarioDto)));
    }

    public UsuarioDto update(String id, UsuarioDto usuarioDto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário de ID: " + id + " não encontrado."));

        if (usuarioDto.nome() != null) {
            usuarioExistente.setNome(usuarioDto.nome());
        }
        if (usuarioDto.email() != null) {
            usuarioExistente.setEmail(usuarioDto.email());
        }
        if (usuarioDto.telefone() != null) {
            usuarioExistente.setTelefone(usuarioDto.telefone());
        }
        if (usuarioDto.tarefas() != null) {
            usuarioExistente.setTarefas(usuarioDto.tarefas());
        }

        return new UsuarioDto(usuarioRepository.save(usuarioExistente));
    }
    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }

}
