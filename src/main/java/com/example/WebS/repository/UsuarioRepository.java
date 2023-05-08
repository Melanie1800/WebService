package com.example.WebS.repository;

import com.example.WebS.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value="select * from usuario", nativeQuery = true)
    List<Usuario> usuarios();
}
