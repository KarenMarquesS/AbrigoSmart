package org.example.abrigosmart.repositorio;

import org.example.abrigosmart.model.FuncaoEnum;
import org.example.abrigosmart.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    // Busca usuário pelo ID
    @Query("from Usuario user where user.id_user = :id_user")
    public Usuario findByIdUsuario(@Param("id_user")int id_user);

    // Busca usuários pela função
    @Query("from Usuario user where user.funcao = :funcao")
    public List<Usuario> findByFuncao(@Param("funcao")FuncaoEnum funcao);

    // Apresenta a lista dos usuários cadastrados em ordem alfabetica
    @Query("from Usuario user order by user.id_user asc")
    public Page<Usuario> findAllOrderByUsuario(Pageable pageable);

    // Busca email do usuário para uso na secretKey
    @Query("select u from Usuario u where u.email = :email")
    public Optional<Usuario> buscarPorEmail(@Param("email") String email);
}
