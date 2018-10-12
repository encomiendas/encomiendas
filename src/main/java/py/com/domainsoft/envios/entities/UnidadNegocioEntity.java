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
@Table(name = "unidad_negocio")
public class UnidadNegocioEntity {
	
	@Id
    @GenericGenerator(name = "unidadNegocioSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "unidad_negocio_id_unidad_negocio_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "unidadNegocioSequenceGenerator")
    
	@Column(name = "id_unidad_negocio")
	private Integer idUnidadNegocio;
	
	private String descripcion;
	
	private Boolean estado;

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getIdUnidadNegocio() {
		return idUnidadNegocio;
	}

	public void setIdUnidadNegocio(Integer idUnidadNegocio) {
		this.idUnidadNegocio = idUnidadNegocio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public int hashCode() {
		return idUnidadNegocio == null ? 0 : idUnidadNegocio.hashCode();
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("idTipoDocumento", idUnidadNegocio).add("descripcion", descripcion)
				.add("estado", estado).toString();
	}

}
