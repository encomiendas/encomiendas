package py.com.domainsoft.envios.dtos;

import java.time.LocalDateTime;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.dtos.SucursalDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public class EquipoDTO {

    private Integer idEquipo;
    private String descripcion;
    private SucursalDTO sucursal;
    private UsuarioDTO usuario;
    private Boolean imprimirFactura;
    private Boolean estado;
    private LocalDateTime fechaLog;

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Boolean getImprimirFactura() {
        return imprimirFactura;
    }

    public void setImprimirFactura(Boolean imprimirFactura) {
        this.imprimirFactura = imprimirFactura;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(LocalDateTime fechaLog) {
        this.fechaLog = fechaLog;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("idEquipo", idEquipo)
                .add("descripcion", descripcion).add("sucursal", sucursal)
                .add("usuario", usuario).add("estado", estado).toString();

    }

}
