package com.minset.mediappbackend.controller;

import com.minset.mediappbackend.model.Especialidad;
import com.minset.mediappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
    @Autowired
    private IEspecialidadService service;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Especialidad>> listar() {
        List<Especialidad> especialidades = new ArrayList<>();
     try {
         especialidades = service.listar();
     }catch (Exception e){
         return new ResponseEntity<List<Especialidad>>(especialidades, HttpStatus.INTERNAL_SERVER_ERROR);
     }
        return new ResponseEntity<List<Especialidad>>(especialidades, HttpStatus.OK);
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Especialidad>> listarId(@PathVariable("id") Integer id) {
        Optional<Especialidad> especialidad = Optional.of(new Especialidad());
        try {
            especialidad = service.listarId(id);
        } catch (Exception e) {
            return new ResponseEntity<>(especialidad, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(especialidad, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> registrar(@RequestBody Especialidad especialidad) {
        int resultado = 0;
        try {
            service.registrar(especialidad);
            resultado = 1;
        } catch (Exception e) {
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Especialidad especialidad) {
        int resultado = 0;
        try {
            service.modificar(especialidad);
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
