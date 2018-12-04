package py.com.domainsoft.envios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "tipo_comprobante")
public class TipoComprobanteEntity {
    @Id
    @GenericGenerator(name = "tipoComprobanteSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "tipo_comprobante_id_tipo_comprobante_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "tipoComprobanteSequenceGenerator")

    @Column(name = "id_tipo_comprobante")
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idTipoComprobante == null || obj == null
                || getClass() != obj.getClass()) {
            return false;
        }
        TipoComprobanteEntity toCompare = (TipoComprobanteEntity) obj;
        return idTipoComprobante.equals(toCompare.idTipoComprobante);
    }

    @Override
    public int hashCode() {
        return idTipoComprobante == null ? 0 : idTipoComprobante.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idTipoComprobante", idTipoComprobante)
                .add("descripcion", descripcion).add("tipo", tipo)
                .add("estado", estado).toString();
    }

}
