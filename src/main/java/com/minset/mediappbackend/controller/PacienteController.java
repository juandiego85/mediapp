package com.minset.mediappbackend.controller;

import com.minset.mediappbackend.model.Paciente;
import com.minset.mediappbackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService service;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Paciente>> listar() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes = service.listar();
        return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.OK);
    }

    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Paciente>> listarId(@PathVariable("id") Integer id) {
        Optional<Paciente> paciente = Optional.of(new Paciente());
        try {
            paciente = service.listarId(id);
        } catch (Exception e) {
            return new ResponseEntity<>(paciente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        Paciente pac = new Paciente();
        try {
            pac=service.registrar(paciente);
        } catch (Exception e) {
            return new ResponseEntity<Paciente>(pac, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Paciente paciente) {
        int resultado = 0;
        try {
            service.modificar(paciente);
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
