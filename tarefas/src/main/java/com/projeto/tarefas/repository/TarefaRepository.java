package com.projeto.tarefas.repository;

import com.projeto.tarefas.model.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, String> {

    Page<Tarefa> findByIsDeletedFalse(Pageable pageable);

    @Query("{'isDeleted': true}")
    List<Tarefa> findAllDeleted();

    @Query("{'isDeleted': true, 'usuario.id': ?0}")
    List<Tarefa> findAllDeletedByUsuarioId(String usuarioId);

    @Query("{'titulo': { $regex: ?0, $options: 'i' }, 'isDeleted': false }")
    List<Tarefa> findByTituloContainingIgnoreCase(String titulo);

    @Query("{'dataCriacao': { $gte: ?0, $lte: ?1 }, 'isDeleted': false }")
    List<Tarefa> findByDataCriacaoBetween(LocalDate startDate, LocalDate endDate);
}
