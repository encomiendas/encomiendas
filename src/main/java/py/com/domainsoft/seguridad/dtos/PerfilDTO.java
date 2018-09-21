package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class PerfilDTO {

    private Integer idPerfil;
    
    private String descripcion;
    
    public PerfilDTO(){};

    public PerfilDTO(Integer idPerfil, String descripcion) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPerfil", idPerfil)
                .add("descripcion", descripcion)
                .toString();
    }  
    
}
