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

    public EnvioDetDTO(Integer idEnvioDet, 
            Integer idEnvio, Integer item,
            ConceptoDTO concepto, String comentario, Double cantidad,
            Double montoTarifa, Double montoTotal, Double montoEnvio,
            MonedaDTO moneda, MonedaDTO monedaEntrega) {
        this.idEnvioDet = idEnvioDet;
        this.idEnvio = idEnvio;
        this.item = item;
        this.concepto = concepto;
        this.comentario = comentario;
        this.cantidad = cantidad;
        this.montoTarifa = montoTarifa;
        this.montoTotal = montoTotal;
        this.montoEnvio = montoEnvio;
        this.moneda = moneda;
        this.monedaEntrega = monedaEntrega;
    }

    public static class Builder {

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

        public Builder idEnvioDet(Integer idEnvioDet) {
            this.idEnvioDet = idEnvioDet;
            return this;
        }

        public Builder idEnvio(Integer idEnvio) {
            this.idEnvio = idEnvio;
            return this;
        }

        public Builder item(Integer item) {
            this.item = item;
            return this;
        }

        public Builder concepto(ConceptoDTO concepto) {
            this.concepto = concepto;
            return this;
        }

        public Builder comentario(String comentario) {
            this.comentario = comentario;
            return this;
        }

        public Builder cantidad(Double cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder montoTarifa(Double montoTarifa) {
            this.montoTarifa = montoTarifa;
            return this;
        }

        public Builder montoTotal(Double montoTotal) {
            this.montoTotal = montoTotal;
            return this;
        }

        public Builder montoEnvio(Double montoEnvio) {
            this.montoEnvio = montoEnvio;
            return this;
        }

        public Builder moneda(MonedaDTO moneda) {
            this.moneda = moneda;
            return this;
        }

        public Builder monedaEntrega(MonedaDTO monedaEntrega) {
            this.monedaEntrega = monedaEntrega;
            return this;
        }

        public EnvioDetDTO build() {
            return new EnvioDetDTO(idEnvioDet, idEnvio, item, concepto,
                    comentario, cantidad, montoTarifa, montoTotal, montoEnvio,
                    moneda, monedaEntrega);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

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
