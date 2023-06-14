package com.springboot.practicaApi.Controller;

import com.springboot.practicaApi.Dto.UsuarioDto;
import com.springboot.practicaApi.Entity.Usuario;
import com.springboot.practicaApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioServiceController {

    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin
    @GetMapping
    public List<UsuarioDto> mostrarUsuarios(){
        return usuarioService.mostrarUsuarios();
    }


    @CrossOrigin
    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody Usuario usuario){
        usuarioService.crearUsuario(usuario);
    }


    @CrossOrigin
    @DeleteMapping(path = "{id}")
    public void eliminarPorId(@PathVariable("id") Integer id) {
        usuarioService.eliminarUsuario(id);
    }

}
