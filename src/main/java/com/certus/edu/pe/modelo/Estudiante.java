package com.certus.edu.pe.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "estudiante")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiante.findByEstudianteDni", query = "SELECT e FROM Estudiante e WHERE e.estudianteDni = :estudianteDni"),
    @NamedQuery(name = "Estudiante.findByPrimerNombre", query = "SELECT e FROM Estudiante e WHERE e.primerNombre = :primerNombre"),
    @NamedQuery(name = "Estudiante.findBySegundoNombre", query = "SELECT e FROM Estudiante e WHERE e.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Estudiante.findByApellidoPaterno", query = "SELECT e FROM Estudiante e WHERE e.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Estudiante.findByApellidoMaterno", query = "SELECT e FROM Estudiante e WHERE e.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Estudiante.findByFechaNacimiento", query = "SELECT e FROM Estudiante e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Estudiante.findByDireccion", query = "SELECT e FROM Estudiante e WHERE e.direccion = :direccion")
})
public class Estudiante implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudiante")
    private Integer idEstudiante;
    
    @Basic(optional = false)
    @Column(name = "Estudiante_dni")
    private String estudianteDni;
    
    @Column(name= "primer_nombre")
    private String primerNombre;
    
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    
    @Column(name="apellido_paterno")
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    
    @Column(name = "direccion")
    private String direccion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso")
    private Curso curso;
    
    public Estudiante() {
        
    }
    
    public Estudiante(Integer idEstudiante, String estudianteDni, String primerNombre, String segundoNombre, 
                      String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.estudianteDni = estudianteDni;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    // Getters y setters

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getEstudianteDni() {
        return estudianteDni;
    }

    public void setEstudianteDni(String estudianteDni) {
        this.estudianteDni = estudianteDni;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante [idEstudiante=" + idEstudiante + ", estudianteDni=" + estudianteDni + ", primerNombre=" + primerNombre
                + ", segundoNombre=" + segundoNombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
                + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + "]";
    }
}
