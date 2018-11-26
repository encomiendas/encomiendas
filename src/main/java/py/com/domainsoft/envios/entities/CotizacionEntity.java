package py.com.domainsoft.envios.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.entities.SucursalEntity;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "cotizacion")
public class CotizacionEntity {
	
	@Id
    @GenericGenerator(name = "cotizacionSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "cotizacion_id_cotizacion_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "cotizacionSequenceGenerator")
    @Column(name = "id_cotizacion")
    private Integer idCotizacion;
	
	@ManyToOne(targetEntity = SucursalEntity.class)
	@JoinColumn(name = "id_sucursal")
	private SucursalEntity sucursal;
    

	@ManyToOne(targetEntity = MonedaEntity.class)
	@JoinColumn(name = "id_moneda_de")
	private MonedaEntity monedaDe;
	
	@ManyToOne(targetEntity = MonedaEntity.class)
	@JoinColumn(name = "id_moneda_a")
	private MonedaEntity monedaA;
	
	@Column(name = "cotiz_compra",columnDefinition = "numeric")
	@NotNull
	private Double cotizCompra;
	
	@Column(name = "cotiz_venta",columnDefinition = "numeric")
	@NotNull
	private Double cotizVenta;
	
	@Column(name = "fecha_log")
	@NotNull
	private Timestamp fechaLog;
	
	@ManyToOne(targetEntity = UsuarioEntity.class)
	@JoinColumn(name = "id_usuario_log")
	private UsuarioEntity usuarioLog;

	public Integer getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}

	public MonedaEntity getMonedaDe() {
		return monedaDe;
	}

	public void setMonedaDe(MonedaEntity monedaDe) {
		this.monedaDe = monedaDe;
	}

	public MonedaEntity getMonedaA() {
		return monedaA;
	}

	public void setMonedaA(MonedaEntity monedaA) {
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

	@CreationTimestamp
	public void setFechaLog(Timestamp fechaLog) {
		this.fechaLog = fechaLog;
	}

	public UsuarioEntity getUsuarioLog() {
		return usuarioLog;
	}

	public void setUsuarioLog(UsuarioEntity usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idCotizacion == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        CotizacionEntity toCompare = (CotizacionEntity) obj;
        return idCotizacion.equals(toCompare.idCotizacion);
    }
	
	@Override
    public int hashCode() {
        return idCotizacion == null ? 0 : idCotizacion.hashCode();
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
