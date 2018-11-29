package py.com.domainsoft.entidad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.domainsoft.envios.entities.ConceptoEntity;
import py.com.domainsoft.envios.entities.MonedaEntity;

@Entity
@Table(name = "envio_det")
public class EnvioDetEntity {

    @Id
    @GenericGenerator(name = "envioDetSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "envio_det_id_envio_det_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "envioDetSequenceGenerator")
    @Column(name = "id_envio_det")
    private Integer idEnvioDet;

    private Integer idEnvio;

    private Integer item;

    @ManyToOne(targetEntity = ConceptoEntity.class)
    @JoinColumn(name = "id_concepto")
    private ConceptoEntity concepto;

    private String comentario;

    private Double cantidad;

    private Double montoTarifa;

    private Double montoTotal;

    private Double montoEnvio;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "id_moneda")
    private MonedaEntity moneda;

    @ManyToOne(targetEntity = MonedaEntity.class)
    @JoinColumn(name = "id_moneda_entrega")
    private MonedaEntity monedaEntrega;

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

    public ConceptoEntity getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoEntity concepto) {
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

    public MonedaEntity getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public MonedaEntity getMonedaEntrega() {
        return monedaEntrega;
    }

    public void setMonedaEntrega(MonedaEntity monedaEntrega) {
        this.monedaEntrega = monedaEntrega;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idEnvioDet == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EnvioDetEntity toCompare = (EnvioDetEntity) obj;
        return idEnvioDet.equals(toCompare.idEnvioDet);
    }

    @Override
    public int hashCode() {
        return idEnvioDet == null ? 0 : idEnvioDet.hashCode();
    }

}
