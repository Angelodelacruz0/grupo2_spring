package com.certus.edu.pe.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "Curso.findByCursoNombre", query = "SELECT c FROM Curso c WHERE c.cursoNombre = :cursoNombre"),
    @NamedQuery(name = "Curso.findByProfesorId", query = "SELECT c FROM Curso c WHERE c.profesorId = :profesorId")
})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCurso")
    private Integer idCurso;

    @Basic(optional = false)
    @Column(name = "Curso_Nombre")
    private String cursoNombre;

    @Lob
    @Column(name = "Curso_Descripcion")
    private String cursoDescripcion;

    @Column(name = "Profesor_id")
    private Integer profesorId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    @JsonBackReference(value="curso_estudiante")
    private List<Estudiante> estudianteList;

    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(Integer idCurso, String cursoNombre, String cursoDescripcion, Integer profesorId) {
        this.idCurso = idCurso;
        this.cursoNombre = cursoNombre;
        this.cursoDescripcion = cursoDescripcion;
        this.profesorId = profesorId;
    }

    // Getters and setters

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    // hashCode, equals, and toString methods

}
