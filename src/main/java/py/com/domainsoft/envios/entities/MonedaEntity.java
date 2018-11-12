package py.com.domainsoft.envios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "moneda")

public class MonedaEntity {


	@Id
	@GenericGenerator(name = "monedaSequenceGenerator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	
	parameters = {
	        @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
	                value = "moneda_id_moneda_seq"),
	        @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
	        value = "1"),
	        @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
	        value = "1") })
	    
	@GeneratedValue(generator = "monedaSequenceGenerator")
	@Column(name = "id_moneda")
	private Integer idMoneda;
	
	@NotNull
	private String descripcion;
	
	private String abreviatura;
	
	private Boolean estado;

	public Integer getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
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
        if (idMoneda == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MonedaEntity toCompare = (MonedaEntity) obj;
        return idMoneda.equals(toCompare.idMoneda);
    }

    @Override
    public int hashCode() {
        return idMoneda == null ? 0 : idMoneda.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("idMoneda", idMoneda)
            .add("descripcion", descripcion)
            .add("abreviatura", abreviatura)
            .add("estado", estado)
            .toString();
}
	
	
}
