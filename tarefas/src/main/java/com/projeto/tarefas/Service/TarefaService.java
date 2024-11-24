package com.projeto.tarefas.Service;

import com.projeto.tarefas.dto.TarefaDto;
import com.projeto.tarefas.model.Tarefa;
import com.projeto.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Page<TarefaDto> findAll(Pageable pageable){
        return tarefaRepository.findAll(pageable).map(TarefaDto::new);
    }

    public TarefaDto findById(String id){
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if(optionalTarefa.isPresent()){
            return new TarefaDto(optionalTarefa.get());
        }
        throw new NoSuchElementException("Tarefa de Id: " + id + " não encontrado.");
    }

    public TarefaDto save(TarefaDto tarefaDto){
        Tarefa tarefa = Tarefa.fromDto(tarefaDto);
        return new TarefaDto(tarefaRepository.save(tarefa));
    }

    public TarefaDto update(String id, TarefaDto tarefaDto){
        Tarefa tarefa = Tarefa.fromDto(tarefaDto);
        tarefa.setId(id);
        return new TarefaDto(tarefaRepository.save(tarefa));
    }

    public void delete(String id){
        tarefaRepository.deleteById(id);
    }

}
