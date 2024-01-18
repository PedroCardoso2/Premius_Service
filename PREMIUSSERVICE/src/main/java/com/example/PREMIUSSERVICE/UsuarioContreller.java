package com.example.PREMIUSSERVICE;

import com.example.PREMIUSSERVICE.Usuario.CadastrarUsuario;
import com.example.PREMIUSSERVICE.Usuario.ListagemUsuario;
import com.example.PREMIUSSERVICE.Usuario.Usuario;
import com.example.PREMIUSSERVICE.Usuario.UsuarioJpaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioContreller {

    @Autowired
    private UsuarioJpaRepository repository;
    @GetMapping("/listagem")
    public Page<ListagemUsuario> listar(@PageableDefault(page = 0)Pageable pageable){
        return repository.findAll(pageable).map(ListagemUsuario::new);
    }

    @GetMapping("/{id}")
    public Usuario encontrar(@PathVariable Long id) {
        return repository.getReferenceById(id);
    }

    @PostMapping
    @Transactional
    public void adicionar(@ResponseBody @Valid CadastrarUsuario cdsUsuario){
        repository.save(new Usuario(cdsUsuario));
    }




}
