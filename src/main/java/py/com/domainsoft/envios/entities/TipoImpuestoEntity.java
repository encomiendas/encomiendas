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

import py.com.domainsoft.entidad.entities.PaisEntity;


@Entity
@Table(name = "tipo_impuesto")
public class TipoImpuestoEntity {
	@Id
    @GenericGenerator(name = "tipoImpuestoSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "tipo_impuesto_id_tipo_impuesto_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "tipoImpuestoSequenceGenerator")
	
	@Column(name = "id_tipo_impuesto")
	private Integer idTipoImpuesto;
	
	private String descripcion;
	
	@Column(columnDefinition = "numeric")
	private Double porcentaje;
	
	@ManyToOne(targetEntity = PaisEntity.class)
    @JoinColumn(name = "id_pais")
    private PaisEntity pais;
	
	private Boolean estado;
	
	@Column(name = "porcentaje_gravado",columnDefinition = "numeric")
	private Double porcentajeGravado;

	public Integer getIdTipoImpuesto() {
		return idTipoImpuesto;
	}

	public void setIdTipoImpuesto(Integer idTipoImpuesto) {
		this.idTipoImpuesto = idTipoImpuesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Double getPorcentajeGravado() {
		return porcentajeGravado;
	}

	public void setPorcentajeGravado(Double porcentajeGravado) {
		this.porcentajeGravado = porcentajeGravado;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (idTipoImpuesto == null || obj == null || getClass() != obj.getClass()) {
			return false;
		}
		TipoImpuestoEntity toCompare = (TipoImpuestoEntity) obj;
		return idTipoImpuesto.equals(toCompare.idTipoImpuesto);
	}
	
	
	@Override
	public int hashCode() {
		return idTipoImpuesto == null ? 0 : idTipoImpuesto.hashCode();
	}	
	
	@Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idTipoImpuesto", idTipoImpuesto)
                .add("descripcion", descripcion)
                .add("porcentaje", porcentaje)
                .add("porcentajeGravado", porcentajeGravado)
                .add("pais", pais)
                .add("estado", estado)
                .toString();
    }
	
    
	
}
