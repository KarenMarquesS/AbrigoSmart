package org.example.abrigosmart.repositorio;

import org.example.abrigosmart.dto.TriagemDTO;
import org.example.abrigosmart.model.Vitima;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VitimaRepositorio {

    // Busca a vitima pelo ID
    @Query("from Vitima vt where vt.id_vitima = :id_vitma")
    public Vitima findByVitima(@Param("id_vitima") int id_vitima);

    // Lista de Vitimas ordenados por idade
    @Query("from Vitima vt order by vt.idade asc ")
    public List<Vitima> listaTodasVitimasPorIdade();

    // Lista as vitimas a partir de uma determinada idade
    @Query("from Vitima vt where vt.idade >= :idade order by vt.idade asc")
    public List<Vitima> listaVitimaPorIdade(@Param("idade") int idade);

    // Pagina com o id_usuario que fez a triagem da vítima
    @Query("SELECT new org.example.abrigosmart.dto.TriagemDTO(u.nome_completo, t.id_triagem, v.id_vitima, " +
            "t.data_triagem) FROM Triagem t JOIN t.usuario u JOIN t.vitima v " +
            "WHERE (:nome IS NULL OR u.nome_completo LIKE %:nome%) ORDER BY t.data_triagem DESC")
    public Page<TriagemDTO> buscarTriagemComInfo(@Param("nome") String nome, Pageable pageable);

}