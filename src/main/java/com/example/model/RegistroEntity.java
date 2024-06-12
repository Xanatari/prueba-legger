package com.example.model;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Registro")
@Entity
public class RegistroEntity implements Serializable {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @Id
    private String id;

    private String nombres;
    private String apellidos;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private EventoEntity evento;

}
