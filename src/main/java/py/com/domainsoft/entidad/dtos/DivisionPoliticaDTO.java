package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class DivisionPoliticaDTO {

	private Integer idDivisionPolitica;

	private String descripcion;

	private Boolean estado;

	private PaisDTO pais;

	public DivisionPoliticaDTO() {}

	public DivisionPoliticaDTO(Integer idDivisionPolitica,
	        String descripcion,
	        Boolean estado,
	        PaisDTO pais) {
		this.idDivisionPolitica = idDivisionPolitica;
		this.descripcion = descripcion;
		this.estado = estado;
		this.pais = pais;
	}

	public static class Builder {

	    private Integer idDivisionPolitica;
	    private String descripcion;
	    private Boolean estado;
	    private PaisDTO pais;

		public Builder idDivisionPolitica(Integer idDivisionPolitica) {
			this.idDivisionPolitica = idDivisionPolitica;
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

		public Builder pais(PaisDTO pais) {
            this.pais = pais;
            return this;
        }
	

		public DivisionPoliticaDTO build() {
			return new DivisionPoliticaDTO(idDivisionPolitica,
			        descripcion,
			        estado,
			        pais);
		}

	}

	public static Builder builder() {
		return new Builder();
	}

    

    public Integer getIdDivisionPolitica() {
        return idDivisionPolitica;
    }

    public void setIdDivisionPolitica(Integer idDivisionPolitica) {
        this.idDivisionPolitica = idDivisionPolitica;
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

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    @Override
	public String toString() {
	   return MoreObjects.toStringHelper(this)
	          .add("idActividadEconomica", idDivisionPolitica)
	          .add("descripcion", descripcion)
	          .add("estado", estado)
	          .add("pais", pais)
	          .toString();
	}

}