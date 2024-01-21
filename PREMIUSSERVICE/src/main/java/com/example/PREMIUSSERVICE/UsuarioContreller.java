package com.example.PREMIUSSERVICE;

import com.example.PREMIUSSERVICE.Usuario.CadastrarUsuarios;
import com.example.PREMIUSSERVICE.Usuario.ListagemUsuarios;
import com.example.PREMIUSSERVICE.Usuario.Usuarios;
import com.example.PREMIUSSERVICE.Usuario.UsuarioJpaRepository;
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
    public Usuarios encontrar(@PathVariable Long id) {
        return repository.getReferenceById(id);
    }

    @PostMapping
    @Transactional
    public void adicionar(@RequestBody @Valid CadastrarUsuarios cdsUsuario){
        repository.save(new Usuarios(cdsUsuario));
    }





}
