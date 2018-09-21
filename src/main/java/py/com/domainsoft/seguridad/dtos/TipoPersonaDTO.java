package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class TipoPersonaDTO {

    private Integer idTipoPersona;

    private String descripcion;

    
    public TipoPersonaDTO() {}
    
    public TipoPersonaDTO(Integer idTipoPersona, String descripcion) {
        this.idTipoPersona = idTipoPersona;
        this.descripcion = descripcion;
    }
    
    
    public static class Builder {

        private Integer idTipoPersona;
        private String descripcion;

        public Builder idTipoPersona(Integer idTipoPersona) {
            this.idTipoPersona = idTipoPersona;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }


        
        public TipoPersonaDTO build() {
            return new TipoPersonaDTO(idTipoPersona, descripcion);
        }

    }
    
    public static Builder builder() {
        return new Builder();
    }

    
    
    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
       return MoreObjects.toStringHelper(this)
              .add("idTipoPersona", idTipoPersona)
              .add("descripcion", descripcion)
              .toString();
    }

}
