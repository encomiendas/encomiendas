package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.dtos.TipoDocumentoDTO.Builder;

public class EstadoCivilDTO {

    private Integer idEstadoCivil;
    
    private String descripcion;
    
    private Boolean estado;
    
    public EstadoCivilDTO() {}
    
    private EstadoCivilDTO( Integer idEstadoCivil, String descripcion, Boolean estado){
        this.idEstadoCivil = idEstadoCivil;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    public static class Builder {
        private Integer idEstadoCivil;
        private String descripcion;
        private Boolean estado;
        
        public Builder idEstadoCivil(Integer idEstadoCivil) {
            this.idEstadoCivil = idEstadoCivil;
            return this;
        }
        
        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        
        public Builder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }
        
        public EstadoCivilDTO build() {
            return new EstadoCivilDTO(idEstadoCivil, descripcion, estado);
        }
        
    }
    
    public static Builder builder() {
        return new Builder();
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idEstadoCivil", idEstadoCivil)
                .add("descripcion", descripcion)
                .add("estado", estado)
                .toString();
    }
    
}
