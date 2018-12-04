package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

public class TipoComprobanteDTO {

    private Integer idTipoComprobante;
    private String descripcion;
    private String tipo;
    private Boolean estado;

    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
                .add("idTipoComprobante", idTipoComprobante)
                .add("descripcion", descripcion).add("tipo", tipo)
                .add("estado", estado).toString();
    }

}
