package com.springboot.practicaApi.Repository;

import com.springboot.practicaApi.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
