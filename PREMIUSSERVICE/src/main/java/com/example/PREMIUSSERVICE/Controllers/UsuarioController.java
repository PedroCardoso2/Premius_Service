package com.example.premiusservice.Controllers;

import com.example.premiusservice.Usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioJpaRepository repository;

    // BUSCAGEM GERAL
    @GetMapping("/list")
    public ResponseEntity<Page<ListagemUsuarios>> listar(@PageableDefault(page = 0)Pageable pageable){
        var usuarios = repository.findAll(pageable).map(ListagemUsuarios::new);
        return ResponseEntity.ok(usuarios);
    }


    // BUSCAGEM ÚNICA
    @GetMapping("/list/{id}")
    public ResponseEntity encontrar(@PathVariable Long id) {
        var usuarios = repository.getReferenceById(id);
        repository.findById(usuarios.getID());

        return ResponseEntity.ok(new ConfirmarDadosUsuario(usuarios));
    }


    //ADICIONAR
    @PostMapping
    @Transactional
    public ResponseEntity adicionar(@RequestBody @Valid CadastrarUsuarios cdsUsuario, UriComponentsBuilder builder){
        var usu = new Usuarios(cdsUsuario);

        repository.save(usu);

        var uri = builder.path("/add").buildAndExpand((usu.getID())).toUri();

        return ResponseEntity.created(uri).body(new ConfirmarDadosUsuario(usu));
    }


    //ATUALIZAÇÃO
    @PutMapping("/atlr")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarUsuario atualizarUsuario){
        var usu = repository.getReferenceById(atualizarUsuario.ID());
        usu.AtualizacaoUsuario(atualizarUsuario);

        return ResponseEntity.ok(new ConfirmarDadosUsuario(usu));
    }


    //DELETAR
    @DeleteMapping("/del/{Id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }


}
