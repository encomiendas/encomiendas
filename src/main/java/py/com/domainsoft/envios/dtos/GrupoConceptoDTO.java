package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

public class GrupoConceptoDTO {
	
	private Integer idGrupoConcepto;
	
	private String descripcion;
	
	private Boolean estado;

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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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
	
