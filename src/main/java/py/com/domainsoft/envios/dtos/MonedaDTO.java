package py.com.domainsoft.envios.dtos;

import com.google.common.base.MoreObjects;

public class MonedaDTO {

	
	private Integer idMoneda;
	
	private String descripcion;
	
	private String abreviatura;
	
	private Boolean estado;
	
	public MonedaDTO() {
		
	}
	
	
	public MonedaDTO(
			Integer idMoneda,
	        String descripcion,
	        String abreviatura,
	        Boolean estado) {
	    
		this.idMoneda = idMoneda;
		this.descripcion = descripcion;
		this.abreviatura = abreviatura;
		this.estado = estado;
	}
	

	public Integer getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	public static class Builder {

	    private Integer idMoneda;
	    private String descripcion;
	    private String abreviatura;
	    private Boolean estado;
	    
		public Builder idMoneda(Integer idMoneda) {
			this.idMoneda = idMoneda;
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
		
		public Builder divisionPolitica(String abreviatura) {
            this.abreviatura = abreviatura;
            return this;
        }		

		public Builder estado(Boolean estado) {
			this.estado = estado;
			return this;
		}


		public MonedaDTO build() {
			return new MonedaDTO(idMoneda,
			        descripcion,
			        abreviatura,
			        estado);
		}

	}
	
	@Override
	public String toString() {
	   return MoreObjects.toStringHelper(this)
	          .add("idMoneda", idMoneda)
	          .add("descripcion", descripcion)
	          .add("abreviatura",abreviatura)
	          .add("estado", estado)
	          .toString();
	}
	
	
}
