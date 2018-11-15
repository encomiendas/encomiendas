package py.com.domainsoft.entidad.dtos;

import py.com.domainsoft.envios.dtos.ConceptoDTO;
import py.com.domainsoft.envios.dtos.MonedaDTO;

public class EnvioDetDTO {

    private Integer idEnvioDet;

    private Integer idEnvio;

    private Integer item;

    private ConceptoDTO concepto;

    private String comentario;

    private Double cantidad;

    private Double montoTarifa;

    private Double montoTotal;

    private Double montoEnvio;

    private MonedaDTO moneda;

    private MonedaDTO monedaEntrega;

    public EnvioDetDTO() {
    };

  
    public Integer getIdEnvioDet() {
        return idEnvioDet;
    }

    public void setIdEnvioDet(Integer idEnvioDet) {
        this.idEnvioDet = idEnvioDet;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public ConceptoDTO getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoDTO concepto) {
        this.concepto = concepto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMontoTarifa() {
        return montoTarifa;
    }

    public void setMontoTarifa(Double montoTarifa) {
        this.montoTarifa = montoTarifa;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoEnvio() {
        return montoEnvio;
    }

    public void setMontoEnvio(Double montoEnvio) {
        this.montoEnvio = montoEnvio;
    }

    public MonedaDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDTO moneda) {
        this.moneda = moneda;
    }

    public MonedaDTO getMonedaEntrega() {
        return monedaEntrega;
    }

    public void setMonedaEntrega(MonedaDTO monedaEntrega) {
        this.monedaEntrega = monedaEntrega;
    }

    @Override
    public String toString() {
        return "EnvioDetDTO [idEnvioDet=" + idEnvioDet + ", idEnvio=" + idEnvio
                + ", item=" + item + ", concepto=" + concepto + ", comentario="
                + comentario + ", cantidad=" + cantidad + ", montoTarifa="
                + montoTarifa + ", montoTotal=" + montoTotal + ", montoEnvio="
                + montoEnvio + ", moneda=" + moneda + ", monedaEntrega="
                + monedaEntrega + "]";
    }

}
