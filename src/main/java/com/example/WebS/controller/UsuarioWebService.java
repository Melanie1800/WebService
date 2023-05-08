package com.example.WebS.controller;

import com.example.WebS.entity.Usuario;
import com.example.WebS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@RestController
@CrossOrigin
public class UsuarioWebService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @GetMapping(value = "/usuarios",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listaUsuarios(){

        return new ResponseEntity(usuarioRepository.usuarios(), HttpStatus.OK);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarUser(
        @RequestBody Usuario usuario,
        @RequestParam (value = "fetchId",required = false) boolean fetchId){
            HashMap<String, Object> responseMap = new HashMap<>();
            usuarioRepository.save(usuario);
            if(fetchId){
                responseMap.put("id",usuario.getIdusuario());
            }
            responseMap.put("estado","creado");
            return new ResponseEntity(responseMap, HttpStatus.CREATED);

        }


}
