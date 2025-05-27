package org.example.abrigosmart.control;

import io.swagger.v3.oas.annotations.Operation;
import org.example.abrigosmart.model.FuncaoEnum;
import org.example.abrigosmart.model.Usuario;
import org.example.abrigosmart.repositorio.UsuarioRepositorio;
import org.example.abrigosmart.servico.UsuarioCachingServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio userR;

    @Autowired
    private UsuarioCachingServico userC;


    @Operation(description = "Este endpoint realiza a inserção de um novo usuário",
            tags = "Inserção de usuário", summary = "Este endpoint realiza a inserção de um novo usuário")
    @PostMapping(value = "/inserir")
    public Usuario inserirUsuario(@RequestBody Usuario user){
        userR.save(user);
        userC.limparCachingUsuario();

//        user.add(linkTo(methodOn(this.getClass()).retornaTodasMusicasCacheable())
//                .withRel("Listar todas as músicas: "));
//        user.add(linkTo(methodOn(this.getClass()).atualizarUsuario(null, user.getId()))
//                .withRel("Gostaria de atualizar a música adicionada? Clique abaixo"));
//        user.add(linkTo(methodOn(this.getClass()).removerUsuario(user.getId()))
//                .withRel("Gostaria de remover a música adicionada? Clique abaixo"));

        return user;
    }


    @GetMapping(value = "/{id)user}")
    public Usuario buscaPorId(@PathVariable int id_user){
        Optional<Usuario> usuario = userR.findById(id_user);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping(value = "/atualizar/{id_user}")
    public Usuario atualizarUsuario(@RequestBody Usuario user, @PathVariable int id_user) {
        Optional<Usuario> u = userR.findById(user.getId_user());

        if (u.isPresent()){
            Usuario usuario = u.get();

            usuario.setNome_completo(user.getNome_completo());
            usuario.setFuncao(user.getFuncao());
            usuario.setEmail(user.getEmail());
            usuario.setSenha(user.getSenha());

            userR.save(usuario);
            userC.limparCachingUsuario();

            return usuario;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/paginado")
    public Page<Usuario> paginadoUsuariosOrdenados(
            @RequestParam(value ="pagina", defaultValue = "0") int page,
            @RequestParam(value ="tamanho", defaultValue = "10") int size,
            @RequestParam(value ="usuario", defaultValue = "id_user") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        return userC.findAllOrderByUsuario(pageable);


//        Page<MusicaDTO> musicas_paginadas = servM.paginar(req);
//
//        musicas_paginadas.forEach(mus -> {
//
//            mus.add(linkTo(methodOn(MusicaController.class).buscaPorID(mus.getId()))
//                    .withRel("Gostaria de ver mais detalhes sobre esta música " + mus.getTitulo() + "? Clique abaixo"));
//
//            mus.add(linkTo(methodOn(this.getClass()).retornaMusicasPorArtista(null))
//                    .withRel("Gostaria de buscar músicas por nome de artista? Clique abaixo"));
//
//            mus.add(linkTo(methodOn(this.getClass()).inserirMusica(null))
//                    .withRel("Gostaria de inserir um nova música? Clique abaixo"));
//
//            mus.add(linkTo(methodOn(IntegranteController.class).retornaIntegrantePorSubstring(null))
//                    .withRel("Gostaria de buscar integrante por substring? Clique abaixo"));
//
//        });

       // return ResponseEntity.ok(musicas_paginadas);


    }


    @GetMapping(value = "/funcao")
    public ResponseEntity<Page<Usuario>> listaUsuarioFuncao(@RequestParam("funcao") FuncaoEnum funcao, Pageable pageable){
        Page<Usuario> u = userR.findByFuncao(funcao, pageable);

        return ResponseEntity.ok(u);
    }



    @DeleteMapping(value = "/{id_user}")
    public Usuario removerUsuario(@PathVariable int id_user) {
        Optional<Usuario> u = userR.findById(id_user);
        if (u.isPresent()){

            Usuario usuario = u.get();
            userR.delete(u.get());
            userC.limparCachingUsuario();
            return usuario;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
