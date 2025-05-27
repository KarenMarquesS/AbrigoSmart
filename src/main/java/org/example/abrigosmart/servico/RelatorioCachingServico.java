package org.example.abrigosmart.servico;


import org.example.abrigosmart.dto.RelatorioDTO;
import org.example.abrigosmart.model.EtapaEnum;
import org.example.abrigosmart.model.Usuario;
import org.example.abrigosmart.repositorio.RelatorioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.example.abrigosmart.model.Relatorio;

@Service
public class RelatorioCachingServico {

    @Autowired
    private RelatorioRepositorio rptR;

    @Cacheable(value = "status_por_etapa", key = "#etapa")
    public List<RelatorioDTO> findyByEtapa(EtapaEnum etapa){
        return rptR.findByEtapa(etapa).stream().map(RelatorioDTO::new).collect(Collectors.toList());
    }

    @Cacheable(value = "busca_ultimo_relatorio_por_usuario", key = "#id_user")
    public List<Usuario> findUsuariosOrdenadosPorUltimaSolicitacao(Integer id_user){
        return rptR.findUsuariosOrdenadosPorUltimaSolicitacao();
    }

    @CacheEvict(value = {"status_por_etapa", "busca_ultimo_relatorio_por_usuario"}, allEntries = true)
    public void limparCachingReport(){
        System.out.println(">> Cachi de Relatório limpo <<");
    }

}
