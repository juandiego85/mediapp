package com.minset.mediappbackend.controller;

import com.minset.mediappbackend.model.Medico;
import com.minset.mediappbackend.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private IMedicoService service;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Medico>> listar() {
        List<Medico> medicos = new ArrayList<>();
        medicos = service.listar();
        return new ResponseEntity<List<Medico>>(medicos, HttpStatus.OK);
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Medico>> listarId(@PathVariable("id") Integer id) {
        Optional<Medico> medico = Optional.of(new Medico());
        try {
            medico = service.listarId(id);
        } catch (Exception e) {
            return new ResponseEntity<>(medico, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> registrar(@RequestBody Medico medico) {
        int resultado = 0;
        try {
            service.registrar(medico);
            resultado = 1;
        } catch (Exception e) {
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Medico medico) {
        int resultado = 0;
        try {
            service.modificar(medico);
            resultado = 1;
        } catch (Exception e) {
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> eliminarId(@PathVariable("id") Integer id) {
        int resultado = 0;
        try {
            service.eliminar(id);
            resultado = 1;
        } catch (Exception e) {
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}
