package py.com.domainsoft.seguridad.dtos;

import java.time.LocalDate;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.dtos.PaisDTO;

public class PersonaDTO {

    private Integer idPersona;
    
    private String nombres;
    
    private String apellidos;
    
    private TipoDocumentoDTO tipoDocumento;
    
    private String documento;

    private TipoDocumentoDTO tipoDocumento2;
    
    private String documento2;
    
    private LocalDate fechaNacimiento;
    
    private String telefono;
    
    private String direccion;
    
    private PaisDTO pais;
    
    private PaisDTO paisNacionalidad;

    private TipoPersonaDTO tipoPersona;
    
    private String genero;
    
    private EstadoCivilDTO estadoCivil;
    
    private Boolean estado;
    
    private String correo;
    
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

    

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
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
                .add("pais", pais)
                .add("paisNacionalidad", paisNacionalidad)
                .add("estadoCivil", estadoCivil)
                .add("correo", correo)
                .toString();
    }
    
}
