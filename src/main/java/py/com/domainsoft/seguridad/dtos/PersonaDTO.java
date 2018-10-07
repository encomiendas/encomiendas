package py.com.domainsoft.seguridad.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.dtos.ActividadEconomicaDTO;
import py.com.domainsoft.entidad.dtos.CiudadDTO;
import py.com.domainsoft.entidad.dtos.PaisDTO;

public class PersonaDTO {

    private Integer idPersona;
    
    private String nombres;
    
    private String apellidos;
    
    private TipoDocumentoDTO tipoDocumento;
    
    private String documento;

    private TipoDocumentoDTO tipoDocumento2;
    
    private String documento2;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    
    private String telefono;
    
    private String direccion;
    
    private PaisDTO paisResidencia;
    
    private PaisDTO paisNacionalidad;

    private TipoPersonaDTO tipoPersona;
    
    private String genero;
    
    private EstadoCivilDTO estadoCivil;
    
    private Boolean estado;
    
    private String correo;
    
    private ActividadEconomicaDTO actividadEconomica;
    
    private CiudadDTO ciudad;
    
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoDocumentoDTO getTipoDocumento2() {
        return tipoDocumento2;
    }

    public void setTipoDocumento2(TipoDocumentoDTO tipoDocumento2) {
        this.tipoDocumento2 = tipoDocumento2;
    }

    public String getDocumento2() {
        return documento2;
    }

    public void setDocumento2(String documento2) {
        this.documento2 = documento2;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public PaisDTO getPaisNacionalidad() {
        return paisNacionalidad;
    }

    public void setPaisNacionalidad(PaisDTO paisNacionalidad) {
        this.paisNacionalidad = paisNacionalidad;
    }

    public TipoPersonaDTO getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaDTO tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public EstadoCivilDTO getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilDTO estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public PaisDTO getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(PaisDTO paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public ActividadEconomicaDTO getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(ActividadEconomicaDTO actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public String getFullName() {
        return this.nombres + " " + (this.apellidos == null ? "" : this.apellidos);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPersona", idPersona)
                .add("nombres", nombres)
                .add("apellidos", apellidos)
                .add("documento", documento)
                .add("documento2", documento2)
                .add("fechaNacimiento", fechaNacimiento)
                .add("telefono", telefono)
                .add("direccion", direccion)
                .add("genero", genero)
                .add("estado", estado)
                .add("tipoPersona", tipoPersona)
                .add("tipoDocumento", tipoDocumento)
                .add("tipoDocumento2", tipoDocumento2)
                .add("paisResidencia", paisResidencia)
                .add("paisNacionalidad", paisNacionalidad)
                .add("estadoCivil", estadoCivil)
                .add("correo", correo)
                .add("ciudad", ciudad)
                .add("actividadEconomica", actividadEconomica)
                .toString();
    }
    
}
