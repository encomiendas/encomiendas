package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

public class TipoDocumentoDTO {
	
	private Integer idTipoDocumento;

	private String descripcion;

	private boolean estado;
	
	private String abreviatura;
	
	public TipoDocumentoDTO() {}
	
	public TipoDocumentoDTO(Integer idTipoDocumento, String descripcion, boolean estado, String abreviatura) {
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = descripcion;
		this.estado = estado;
		this.abreviatura = abreviatura;
	}
	
	
	public static class Builder {

		private Integer idTipoDocumento;
		private String descripcion;
		private boolean estado;
		private String abreviatura;

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
		
		public Builder abreviatura(String abreviatura) {
            this.abreviatura = abreviatura;
            return this;
        }

		
		public TipoDocumentoDTO build() {
			return new TipoDocumentoDTO(idTipoDocumento, descripcion, estado, abreviatura);
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
	
	
	
	public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
	public String toString() {
	   return MoreObjects.toStringHelper(this)
	          .add("idTipoDocumento", idTipoDocumento)
	          .add("descripcion", descripcion)
	          .add("estado", estado)
	          .add("abreviatura", abreviatura)
	          .toString();
	}


}
