package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class TipoDocumentoDTO {
	
	private Integer idTipoDocumento;

	private String descripcion;

	private boolean estado;
	
	public TipoDocumentoDTO() {}
	
	public TipoDocumentoDTO(Integer idTipoDocumento, String descripcion, boolean estado) {
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	
	public static class Builder {

		private Integer idTipoDocumento;
		private String descripcion;
		private boolean estado;

		public Builder idTipoDocumento(Integer idTipoDocumento) {
			this.idTipoDocumento = idTipoDocumento;
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

		
		public TipoDocumentoDTO build() {
			return new TipoDocumentoDTO(idTipoDocumento, descripcion, estado);
		}

	}
	
	public static Builder builder() {
		return new Builder();
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
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
	          .add("idTipoDocumento", idTipoDocumento)
	          .add("descripcion", descripcion)
	          .add("estado", estado)
	          .toString();
	}


}
