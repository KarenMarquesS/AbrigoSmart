package org.example.abrigosmart.servico;


import org.example.abrigosmart.model.FuncaoEnum;
import org.example.abrigosmart.model.Usuario;
import org.example.abrigosmart.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioCachingServico {

    @Autowired
    public UsuarioRepositorio userR;

    @Cacheable(value ="usuario_id", key = "#id_user")
    public Optional<Usuario> findByIdUsuario(int id_user) {
        return Optional.ofNullable(userR.findByIdUsuario(id_user));
    }

    @Cacheable(value = "usuario_paginado_funcao", key = "#funcao")
    public Page<Usuario> findByFuncao(FuncaoEnum funcao, Pageable pageable) {
        List<Usuario> listUsuario = userR.findByFuncao(funcao);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), listUsuario.size());
        return new PageImpl<>(listUsuario.subList(start, end), pageable, listUsuario.size());
    }

    @Cacheable(value = "usuario_por_ordem", key = "'page_' + #pageable.pageNumber + '_size_' + #pageable.pageSize")
    public Page<Usuario> findAllOrderByUsuario(Pageable pageable) {
        return userR.findAllOrderByUsuario(pageable);
    }

    @CacheEvict(value = {"usuario_id", "usuario_paginado_funcao", "usuario_por_ordem"}, allEntries = true)
    public void limparCachingUsuario(){
        System.out.println(">> Caching do Usuário limpo <<");
    }
}
