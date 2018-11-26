package py.com.domainsoft.envios.dtos;

import java.sql.Timestamp;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.dtos.SucursalDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public class CotizacionDTO {
	
	    private Integer idCotizacion;
		
		private SucursalDTO sucursal;
	    
		private MonedaDTO monedaDe;
		
		private MonedaDTO monedaA;
		
		private Double cotizCompra;
		
		private Double cotizVenta;
		
		private Timestamp fechaLog;
		
		private UsuarioDTO usuarioLog;

		public Integer getIdCotizacion() {
			return idCotizacion;
		}

		public void setIdCotizacion(Integer idCotizacion) {
			this.idCotizacion = idCotizacion;
		}

		public SucursalDTO getSucursal() {
			return sucursal;
		}

		public void setSucursal(SucursalDTO sucursal) {
			this.sucursal = sucursal;
		}

		public MonedaDTO getMonedaDe() {
			return monedaDe;
		}

		public void setMonedaDe(MonedaDTO monedaDe) {
			this.monedaDe = monedaDe;
		}

		public MonedaDTO getMonedaA() {
			return monedaA;
		}

		public void setMonedaA(MonedaDTO monedaA) {
			this.monedaA = monedaA;
		}

		public Double getCotizCompra() {
			return cotizCompra;
		}

		public void setCotizCompra(Double cotizCompra) {
			this.cotizCompra = cotizCompra;
		}

		public Double getCotizVenta() {
			return cotizVenta;
		}

		public void setCotizVenta(Double cotizVenta) {
			this.cotizVenta = cotizVenta;
		}

		public Timestamp getFechaLog() {
			return fechaLog;
		}

		public void setFechaLog(Timestamp fechaLog) {
			this.fechaLog = fechaLog;
		}

		public UsuarioDTO getUsuarioLog() {
			return usuarioLog;
		}

		public void setUsuarioLog(UsuarioDTO usuarioLog) {
			this.usuarioLog = usuarioLog;
		}
		
		
	    @Override
	    public String toString() {
	        return MoreObjects.toStringHelper(this)
	                .add("idCotizacion", idCotizacion)
	                .add("sucursal", sucursal)
	                .add("monedaDe", monedaDe)
	                .add("monedaA", monedaA)
	                .add("cotizCompra", cotizCompra)
	                .add("cotizVenta", cotizVenta)
	                .add("fechaLog", fechaLog)
	                .add("usuarioLog", usuarioLog)
	                .toString();
	    }



}
