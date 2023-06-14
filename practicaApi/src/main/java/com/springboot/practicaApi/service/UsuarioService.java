package com.springboot.practicaApi.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.practicaApi.Dto.UsuarioDto;
import com.springboot.practicaApi.Entity.Usuario;
import com.springboot.practicaApi.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioService {
    @Autowired
    private final IUsuarioRepository UsuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        UsuarioRepository = usuarioRepository;
    }



    public void crearUsuario (Usuario usuario) {
        UsuarioRepository.save(usuario);
    }


    public List<UsuarioDto> mostrarUsuarios() {
        List<Usuario> listaUsuarios = UsuarioRepository.findAll();
        ObjectMapper mapper =new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return listaUsuarios.stream().map(usuario -> mapper.convertValue(usuario,UsuarioDto.class)).collect(Collectors.toList());
    }


    public void eliminarUsuario(Integer id) {
        UsuarioRepository.deleteById(id);
    }


}
