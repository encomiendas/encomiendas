package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class PaginaDTO {

    private Integer idPagina;

    private String descripcion;

    public Integer getIdPagina() {
        return idPagina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdPagina(Integer idPagina) {
        this.idPagina = idPagina;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPagina", idPagina)
                .add("descripcion", descripcion)
                .toString();
    }
    
}
