package com.springboot.practicaApi.service;

import com.springboot.practicaApi.Entity.Usuario;
import com.springboot.practicaApi.Repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final IUsuarioRepository UsuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        UsuarioRepository = usuarioRepository;
    }



    public void crearUsuario (Usuario usuario) {
        UsuarioRepository.save(usuario);
    }


    public List<Usuario> mostrarUsuarios() {
       return UsuarioRepository.findAll();
    }


    public void eliminarUsuario(Integer id) {
        UsuarioRepository.deleteById(id);
    }


//    public ArrayList<Usuario> mostrarUsuario(){
//        //1.- LEVANTAR EL DRIVER Y CONECTARNOS
//
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//
//        Connection conexion = null;
//        try {
//            Class.forName("org.h2.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            conexion = DriverManager.getConnection("jdbc:h2:~/Usuarios2", "sa", "sa");
//
//
//            //2.-CREAR SENTENCIAS
//            PreparedStatement prepareStmt = conexion.prepareStatement("SELECT * FROM USUARIO");
//
//
//
//
//            //3.-EJECUTAR SENTENCIAS
//
//            ResultSet resultquery = prepareStmt.executeQuery();
//
//            while(resultquery.next()){
//                Usuario usuario = new Usuario();
//                usuario.setId(resultquery.getInt(1));
//                usuario.setNombre(resultquery.getString(2));
//                usuario.setApellido(resultquery.getString(3));
//                usuarios.add(usuario);
//            }
//
//
//            prepareStmt.close();
//
//
//
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                assert conexion != null;
//                conexion.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return usuarios;
//    }




}
