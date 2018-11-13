package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.dtos.PaisDTO;

public class TipoImpuestoDTO {
	
	
	private Integer idTipoImpuesto;
	
	private String descripcion;
	
	private Double porcentaje;
	
    private PaisDTO pais;
	
	private Boolean estado;
	
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

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
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
