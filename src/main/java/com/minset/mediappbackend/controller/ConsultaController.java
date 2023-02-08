package com.minset.mediappbackend.controller;

import com.minset.mediappbackend.model.Consulta;
import com.minset.mediappbackend.model.DetalleConsulta;
import com.minset.mediappbackend.model.Especialidad;
import com.minset.mediappbackend.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private IConsultaService service;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Consulta>> listar() {
        List<Consulta> consultas = new ArrayList<>();
        try {
            consultas = service.listar();
        }catch (Exception e){
            return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrar(@RequestBody Consulta consulta) {
       Consulta con=new Consulta();
        try {
            con=service.registrar(consulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(con.toString(), HttpStatus.OK);
    }
}
