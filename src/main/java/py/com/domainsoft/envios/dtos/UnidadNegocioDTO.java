package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

public class UnidadNegocioDTO {
	
	private Integer idUnidadNegocio;

	private String descripcion;

	private boolean estado;

	public UnidadNegocioDTO() {

	}

	public Integer getIdUnidadNegocio() {
		return idUnidadNegocio;
	}

	public void setIdUnidadNegocio(Integer idUnidadNegocio) {
		this.idUnidadNegocio = idUnidadNegocio;
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





	public UnidadNegocioDTO(Integer idUnidadNegocio,
	        String descripcion,
	        boolean estado) {
		this.idUnidadNegocio = idUnidadNegocio;
		this.descripcion = descripcion;
		this.estado = estado;
	}


	public static class Builder {

		private Integer idUnidadNegocio;

		private String descripcion;

		private boolean estado;

		public Builder idUnidadNegocio(Integer idUnidadNegocio) {
			this.idUnidadNegocio = idUnidadNegocio;
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder estado(boolean estado) {
			this.estado = estado;
			return this;
		}
		
		
		public UnidadNegocioDTO build() {
			return new UnidadNegocioDTO(
					idUnidadNegocio,
			        descripcion,
			        estado);
		}

	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
	   return MoreObjects.toStringHelper(this)
	          .add("idUnidadNegocio", idUnidadNegocio)
	          .add("descripcion", descripcion)
	          .add("estado", estado)
	          .toString();
	}

	

}
