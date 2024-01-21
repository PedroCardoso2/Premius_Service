package com.example.PREMIUSSERVICE;

import com.example.PREMIUSSERVICE.Usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioContreller {

    @Autowired
    private UsuarioJpaRepository repository;
    @GetMapping("/listagem")
    public Page<ListagemUsuarios> listar(@PageableDefault(page = 0)Pageable pageable){
        return repository.findAll(pageable).map(ListagemUsuarios::new);
    }

    @GetMapping("/{id}")
    public UsuarioEncontra encontrar(@PathVariable Long id) {
        Usuarios usuarios = repository.getReferenceById(id);
        return new UsuarioEncontra(usuarios.getID(), usuarios.getSenha(), usuarios.getCPF(), usuarios.getNome());
    }

    @PostMapping
    @Transactional
    public void adicionar(@RequestBody @Valid CadastrarUsuarios cdsUsuario){
        repository.save(new Usuarios(cdsUsuario));
    }

}
