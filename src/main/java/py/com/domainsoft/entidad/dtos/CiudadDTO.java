package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class CiudadDTO {

	private Integer idCiudad;

	private String descripcion;

	private Boolean estado;

	private DivisionPoliticaDTO divisionPolitica;

	public CiudadDTO() {}

	public CiudadDTO(Integer idCiudad,
	        String descripcion,
	        Boolean estado,
	        DivisionPoliticaDTO divisionPolitica) {
	    this.idCiudad = idCiudad;
		this.divisionPolitica = divisionPolitica;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public static class Builder {

	    private Integer idCiudad;
	    private String descripcion;
	    private Boolean estado;
	    private DivisionPoliticaDTO divisionPolitica;

		public Builder idCiudad(Integer idCiudad) {
			this.idCiudad = idCiudad;
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

		public Builder divisionPolitica(DivisionPoliticaDTO divisionPolitica) {
            this.divisionPolitica = divisionPolitica;
            return this;
        }
	

		public CiudadDTO build() {
			return new CiudadDTO(idCiudad,
			        descripcion,
			        estado,
			        divisionPolitica);
		}

	}

	public static Builder builder() {
		return new Builder();
	}
    

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
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

    public DivisionPoliticaDTO getDivisionPolitica() {
        return divisionPolitica;
    }

    public void setDivisionPolitica(DivisionPoliticaDTO divisionPolitica) {
        this.divisionPolitica = divisionPolitica;
    }

    @Override
	public String toString() {
	   return MoreObjects.toStringHelper(this)
	          .add("idCiudad", idCiudad)
	          .add("descripcion", descripcion)
	          .add("estado", estado)
	          .add("divisionPolitica", divisionPolitica)
	          .toString();
	}

}