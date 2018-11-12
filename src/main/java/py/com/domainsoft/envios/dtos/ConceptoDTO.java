package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

public class ConceptoDTO {
	
	
	private Integer idConcepto;
	
    private GrupoConceptoDTO grupoConcepto;
	
	private String descripcion;

	private Boolean estado;
	
	private TipoImpuestoDTO tipoImpuesto;

	public Integer getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public GrupoConceptoDTO getGrupoConcepto() {
		return grupoConcepto;
	}

	public void setGrupoConcepto(GrupoConceptoDTO grupoConcepto) {
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

	public TipoImpuestoDTO getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(TipoImpuestoDTO tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
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
