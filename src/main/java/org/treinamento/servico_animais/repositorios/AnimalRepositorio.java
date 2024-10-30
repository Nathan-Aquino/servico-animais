package org.treinamento.servico_animais.repositorios;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.treinamento.servico_animais.entidades.Animal;

public interface AnimalRepositorio extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> listarNaoAdotados();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> listarAdotados();

    @Query("SELECT a.nomeRecebedor AS nomeFuncionario, COUNT(a.id) AS quantidadeResgatados " +
           "FROM Animal a " +
           "WHERE a.dataEntrada BETWEEN :dataInicio AND :dataFim " +
           "GROUP BY a.nomeRecebedor " +
           "HAVING COUNT(a.id) > 0 " +
           "ORDER BY quantidadeResgatados DESC")
    List<Object[]> contarAnimaisResgatadosPorFuncionario(@Param("dataInicio") Date dataInicio, 
                                                         @Param("dataFim") Date dataFim);
}
