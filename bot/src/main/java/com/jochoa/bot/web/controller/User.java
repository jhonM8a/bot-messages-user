package com.jochoa.bot.web.controller;

import com.jochoa.bot.domain.Usuario;
import com.jochoa.bot.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class User {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{userId}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("userId") Integer userId){
        return usuarioService.getUsuario(userId).map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario).map(usuario1 -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario).map(usuario1 -> new ResponseEntity<>(usuario, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUsuario(@PathVariable("userId") Integer userId){
        return usuarioService.deleteUsuario(userId)?  new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
