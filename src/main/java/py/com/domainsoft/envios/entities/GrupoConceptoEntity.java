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
@Table(name = "grupo_concepto")
public class GrupoConceptoEntity {
	
	@Id
    @GenericGenerator(name = "GrupoConceptoSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "grupo_concepto_id_grupo_concepto_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "GrupoConceptoSequenceGenerator")
    @Column(name = "id_grupo_concepto")
	private Integer idGrupoConcepto;
	
	private String descripcion;
	
	private boolean estado;

	public Integer getIdGrupoConcepto() {
		return idGrupoConcepto;
	}

	public void setIdGrupoConcepto(Integer idGrupoConcepto) {
		this.idGrupoConcepto = idGrupoConcepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idGrupoConcepto == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GrupoConceptoEntity toCompare = (GrupoConceptoEntity) obj;
        return idGrupoConcepto.equals(toCompare.idGrupoConcepto);
    }

    @Override
    public int hashCode() {
        return idGrupoConcepto == null ? 0 : idGrupoConcepto.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idGrupoConcepto", idGrupoConcepto)
                .add("descripcion", descripcion)
                .add("estado", estado)
                .toString();
    }
	

}
