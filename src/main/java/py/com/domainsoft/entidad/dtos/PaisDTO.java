package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class PaisDTO {

	private Integer idPais;

	private String descripcion;

	private String gentilicio;

	private Integer codPaisNum;

	private String codPaisAlfa2;
	
	private String codPaisAlfa3;

	public PaisDTO() {}

	public PaisDTO(Integer idpais,
	        String descripcion,
	        String gentilicio,
	        Integer codPaisNum,
	        String codPaisAlfa2,
	        String codPaisAlfa3) {
		this.idPais = idpais;
		this.descripcion = descripcion;
		this.gentilicio = gentilicio;
		this.codPaisNum = codPaisNum;
		this.codPaisAlfa2 = codPaisAlfa2;
		this.codPaisAlfa3 = codPaisAlfa3;
	}

	public static class Builder {

		private Integer idPais;
		private String descripcion;
		private String gentilicio;
		private Integer codPaisNum;
		private String codPaisAlfa2;
		private String codPaisAlfa3;

		public Builder idPais(Integer idPais) {
			this.idPais = idPais;
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder gentilicio(String gentilicio) {
			this.gentilicio = gentilicio;
			return this;
		}

		public Builder codPaisNum(Integer codPaisNum) {
			this.codPaisNum = codPaisNum;
			return this;
		}

		public Builder codPaisAlfa2(String codPaisAlfa2) {
			this.codPaisAlfa2 = codPaisAlfa2;
			return this;
		}

		public PaisDTO build() {
			return new PaisDTO(idPais,
			        descripcion,
			        gentilicio,
			        codPaisNum,
			        codPaisAlfa2,
			        codPaisAlfa3);
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGentilicio() {
		return gentilicio;
	}

	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}

	public Integer getCodPaisNum() {
		return codPaisNum;
	}

	public void setCodPaisNum(Integer codPaisNum) {
		this.codPaisNum = codPaisNum;
	}

	public String getCodPaisAlfa2() {
		return codPaisAlfa2;
	}

	public void setCodPaisAlfa2(String codPaisAlfa2) {
		this.codPaisAlfa2 = codPaisAlfa2;
	}
	
	public String getCodPaisAlfa3() {
        return codPaisAlfa3;
    }

    public void setCodPaisAlfa3(String codPaisAlfa3) {
        this.codPaisAlfa3 = codPaisAlfa3;
    }

    @Override
	public String toString() {
	   return MoreObjects.toStringHelper(this)
	          .add("idPais", idPais)
	          .add("descripcion", descripcion)
	          .add("gentilicio", gentilicio)
	          .add("codPaisNum", codPaisNum)
	          .add("codPaisAlfa2", codPaisAlfa2)
	          .toString();
	}

}