package org.example.abrigosmart.repositorio;

import org.example.abrigosmart.model.AtendimentoEnum;
import org.example.abrigosmart.model.Relatorio;
import org.example.abrigosmart.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioRepositorio extends JpaRepository<Relatorio, Integer> {


    // Apresenta Status de cada etapa do processo da assitencia a vitima
    @Query("from Relatorio rlt where rlt.etapa = :etapa")
    public List<Relatorio> findByEtapa(@Param("etapa") AtendimentoEnum etapa);

    // Apresenta qual usuário fez a ultima solicitação em ordem decrescente do relatorio
    //@Query("select rlt.gerado_pelo_usuario from Relatorio rlt order by rlt.data_relatorio desc")
    public List<Usuario> findUsuariosOrdenadosPorUltimaSolicitacao();



}
