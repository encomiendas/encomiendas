package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class PaginaDTO {

    private Integer idPagina;

    private String descripcion;
    
    private String url;
    
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
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPagina", idPagina)
                .add("descripcion", descripcion)
                .add("url", url)
                .toString();
    }
    
}
