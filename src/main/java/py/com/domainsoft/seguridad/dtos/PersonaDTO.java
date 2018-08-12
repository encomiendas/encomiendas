package py.com.domainsoft.seguridad.dtos;

import java.time.LocalDate;

import py.com.domainsoft.entidad.entities.PaisEntity;
import py.com.domainsoft.seguridad.entities.EstadoCivilEntity;
import py.com.domainsoft.seguridad.entities.TipoDocumentoEntity;
import py.com.domainsoft.seguridad.entities.TipoPersonaEntity;

public class PersonaDTO {

    private Integer idPersona;
    
    private String nombres;
    
    private String apellidos;
    
    private TipoDocumentoEntity tipoDocumento;
    
    private String documento;

    private TipoDocumentoEntity tipoDocumento2;
    
    private String documento2;
    
    private LocalDate fechaNacimiento;
    
    private String telefono;
    
    private String direccion;
    
    private PaisEntity pais;
    
    private PaisEntity paisNacionalidad;

    private TipoPersonaEntity tipoPersona;
    
    private String genero;
    
    private EstadoCivilEntity estadoCivil;
    
    private Boolean estado;
    
    public PersonaDTO() {}
    
    private PersonaDTO(Integer idPersona, String nombres, String apellidos,
            TipoDocumentoEntity tipoDocumento, String documento,
            TipoDocumentoEntity tipoDocumento2, String documento2,
            LocalDate fechaNacimiento, String telefono, String direccion,
            PaisEntity pais, PaisEntity paisNacionalidad,
            TipoPersonaEntity tipoPersona, String genero,
            EstadoCivilEntity estadoCivil, Boolean estado) {
        
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.tipoDocumento2 = tipoDocumento2;
        this.documento2 = documento2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pais = pais;
        this.paisNacionalidad = paisNacionalidad;
        this.tipoPersona = tipoPersona;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.estado = estado;
        
        
    }

    public static class Builder {
        private Integer idPersona;
        private String nombres;
        private String apellidos;
        private TipoDocumentoEntity tipoDocumento;
        private String documento;
        private TipoDocumentoEntity tipoDocumento2;
        private String documento2;
        private LocalDate fechaNacimiento;
        private String telefono;
        private String direccion;
        private PaisEntity pais;
        private PaisEntity paisNacionalidad;
        private TipoPersonaEntity tipoPersona;
        private String genero;
        private EstadoCivilEntity estadoCivil;
        private Boolean estado;
        
        public Builder idPersona(Integer idPersona) {
            this.idPersona = idPersona;
            return this;
        }
        public Builder nombres(String nombres) {
            this.nombres = nombres;
            return this;
        }
        public Builder apellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }
        public Builder tipoDocumento(TipoDocumentoEntity tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
            return this;
        }
        public Builder documento(String documento) {
            this.documento = documento;
            return this;
        }
        public Builder tipoDocumento2(TipoDocumentoEntity tipoDocumento2) {
            this.tipoDocumento2 = tipoDocumento2;
            return this;
        }
        public Builder documento2(String documento2) {
            this.documento2 = documento2;
            return this;
        }
        
        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }
        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }
        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }
        public Builder pais(PaisEntity pais) {
            this.pais = pais;
            return this;
        }
        public Builder paisNacionalidad(PaisEntity paisNacionalidad) {
            this.paisNacionalidad = paisNacionalidad;
            return this;
        }
        public Builder tipoPersona(TipoPersonaEntity tipoPersona) {
            this.tipoPersona = tipoPersona;
            return this;
        }
        public Builder genero(String genero) {
            this.genero = genero;
            return this;
        }
        public Builder estadoCivil(EstadoCivilEntity estadoCivil) {
            this.estadoCivil = estadoCivil;
            return this;
        }
        public Builder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }
        
        public PersonaDTO build() {
            return new PersonaDTO(idPersona,nombres,apellidos,tipoDocumento,
                    documento, tipoDocumento2, documento2,fechaNacimiento,
                    telefono, direccion, pais, paisNacionalidad, tipoPersona, genero,
                    estadoCivil, estado);
        }
                
    }


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

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoDocumentoEntity getTipoDocumento2() {
        return tipoDocumento2;
    }

    public void setTipoDocumento2(TipoDocumentoEntity tipoDocumento2) {
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

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }

    public PaisEntity getPaisNacionalidad() {
        return paisNacionalidad;
    }

    public void setPaisNacionalidad(PaisEntity paisNacionalidad) {
        this.paisNacionalidad = paisNacionalidad;
    }

    public TipoPersonaEntity getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaEntity tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EstadoCivilEntity getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilEntity estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
