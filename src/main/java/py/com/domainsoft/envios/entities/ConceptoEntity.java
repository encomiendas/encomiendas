package py.com.domainsoft.envios.entities;

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

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "concepto")
public class ConceptoEntity {
	
	@Id
    @GenericGenerator(name = "conceptoSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "concepto_id_concepto_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "conceptoSequenceGenerator")
	
	@Column(name = "id_concepto")
	private Integer idConcepto;
	
	@ManyToOne(targetEntity = GrupoConceptoEntity.class)
    @JoinColumn(name = "id_grupo_concepto")
    private GrupoConceptoEntity grupoConcepto;
	
	private String descripcion;
	private Boolean estado;
	
	@ManyToOne(targetEntity = TipoImpuestoEntity.class)
    @JoinColumn(name = "id_tipo_impuesto")
	private TipoImpuestoEntity tipoImpuesto;

	public Integer getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public GrupoConceptoEntity getGrupoConcepto() {
		return grupoConcepto;
	}

	public void setGrupoConcepto(GrupoConceptoEntity grupoConcepto) {
		this.grupoConcepto = grupoConcepto;
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

	public TipoImpuestoEntity getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(TipoImpuestoEntity tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (idConcepto == null || obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ConceptoEntity toCompare = (ConceptoEntity) obj;
		return idConcepto.equals(toCompare.idConcepto);
	}
	
	@Override
	public int hashCode() {
		return idConcepto == null ? 0 : idConcepto.hashCode();
	}	
	
	@Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idConcepto", idConcepto)
                .add("grupoConcepto",grupoConcepto)
                .add("descripcion", descripcion)
                .add("tipoImpuesto", tipoImpuesto)
                .add("estado", estado)
                .toString();
    }
	


}
