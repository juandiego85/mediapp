package com.minset.mediappbackend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;

    @ManyToOne
    @JoinColumn(name="id_paciente",nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="id_medico",nullable = false)
    private Medico medico;
    @ManyToOne
    @JoinColumn(name="id_especialidad",nullable = false)
    private Especialidad especialidad;
    @JsonSerialize(using= ToStringSerializer.class)
    private LocalDateTime fecha;

    @OneToMany(mappedBy="consulta",cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch=FetchType.LAZY,orphanRemoval=true)
    private List<DetalleConsulta> detalleConsultaList;

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<DetalleConsulta> getDetalleConsultaList() {
        return detalleConsultaList;
    }

    public void setDetalleConsultaList(List<DetalleConsulta> detalleConsultaList) {
        this.detalleConsultaList = detalleConsultaList;
    }
}
