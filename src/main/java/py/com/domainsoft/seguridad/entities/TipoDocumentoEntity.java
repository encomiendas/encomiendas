package py.com.domainsoft.seguridad.entities;

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
@Table(name = "tipo_documento")
public class TipoDocumentoEntity {
    
    @Id
    @GenericGenerator(name = "tipoDocumentoSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "tipo_documento_id_tipo_documento_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "tipoDocumentoSequenceGenerator")
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    
    private String descripcion;
    
    private Boolean estado;

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
    public int hashCode() {
        return idTipoDocumento == null ? 0 : idTipoDocumento.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idTipoDocumento", idTipoDocumento)
                .add("descripcion", descripcion)
                .add("estado", estado)
                .toString();
    }
    
}
