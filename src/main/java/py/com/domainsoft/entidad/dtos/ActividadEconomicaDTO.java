package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class ActividadEconomicaDTO {

	private Integer idActividadEconomica;

	private String descripcion;

	private Boolean estado;

	

	public ActividadEconomicaDTO() {}

	public ActividadEconomicaDTO(Integer idActividadEconomica,
	        String descripcion,
	        Boolean estado) {
		this.idActividadEconomica = idActividadEconomica;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public static class Builder {

	    private Integer idActividadEconomica;
	    private String descripcion;
	    private Boolean estado;

		public Builder idActividadEconomica(Integer idActividadEconomica) {
			this.idActividadEconomica = idActividadEconomica;
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder estado(Boolean estado) {
			this.estado = estado;
			return this;
		}

	

		public ActividadEconomicaDTO build() {
			return new ActividadEconomicaDTO(idActividadEconomica,
			        descripcion,
			        estado);
		}

	}

	public static Builder builder() {
		return new Builder();
	}

    public Integer getIdActividadEconomica() {
        return idActividadEconomica;
    }

    public void setIdActividadEconomica(Integer idActividadEconomica) {
        this.idActividadEconomica = idActividadEconomica;
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
	          .add("idActividadEconomica", idActividadEconomica)
	          .add("descripcion", descripcion)
	          .add("estado", estado)
	          .toString();
	}

}