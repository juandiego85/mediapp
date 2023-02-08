package com.minset.mediappbackend.controller;

import com.minset.mediappbackend.model.Examen;
import com.minset.mediappbackend.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
    @Autowired
    private IExamenService service;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Examen>> listar() {
        List<Examen> examenes = new ArrayList<>();
        examenes = service.listar();
        return new ResponseEntity<List<Examen>>(examenes, HttpStatus.OK);
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Examen>> listarId(@PathVariable("id") Integer id) {
        Optional<Examen> examen = Optional.of(new Examen());
        try {
            examen = service.listarId(id);
        } catch (Exception e) {
            return new ResponseEntity<>(examen, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(examen, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> registrar(@RequestBody Examen examen) {
        int resultado = 0;
        try {
            service.registrar(examen);
            resultado = 1;
        } catch (Exception e) {
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Examen examen) {
        int resultado = 0;
        try {
            service.modificar(examen);
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
