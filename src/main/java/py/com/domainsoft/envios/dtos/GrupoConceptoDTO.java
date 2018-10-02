package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

public class GrupoConceptoDTO {
	
	Integer idGrupoConcepto;
	
	String descripcion;
	
	boolean estado;

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
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idGrupoConcepto", idGrupoConcepto)
                .add("descripcion", descripcion)
                .add("estado", estado)
                .toString();

	}
}
	
