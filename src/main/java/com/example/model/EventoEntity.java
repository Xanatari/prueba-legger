package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Evento")
public class EventoEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    private String nombre;
    private Date fecha;
    private String descripcion;
    private boolean estado;

    @ElementCollection
    @CollectionTable(name = "Evento_Lugares", joinColumns = @JoinColumn(name = "evento_id"))
    @Column(name = "lugar_id")
    private List<String> lugaresId;
}