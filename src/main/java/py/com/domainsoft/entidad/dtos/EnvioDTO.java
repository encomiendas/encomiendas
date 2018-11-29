package py.com.domainsoft.entidad.dtos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public class EnvioDTO {

    private Integer idEnvio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime fechaEnvio;

    private SucursalDTO sucursal;

    private ClienteDTO clienteRemitente;

    private ClienteDTO clienteDestinatario;

    private String estado;

    private UnidadNegocioDTO unidadNegocio;

    private String entregado;

    private UsuarioDTO usuario;

    private UsuarioDTO usuarioLog;

    private LocalDateTime fechaLog;

    private PaisDTO paisDestino;

    private SucursalDTO sucursalDestino;

    private List<EnvioDetDTO> detalles;

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public ClienteDTO getClienteRemitente() {
        return clienteRemitente;
    }

    public void setClienteRemitente(ClienteDTO clienteRemitente) {
        this.clienteRemitente = clienteRemitente;
    }

    public ClienteDTO getClienteDestinatario() {
        return clienteDestinatario;
    }

    public void setClienteDestinatario(ClienteDTO clienteDestinatario) {
        this.clienteDestinatario = clienteDestinatario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UnidadNegocioDTO getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(UnidadNegocioDTO unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(UsuarioDTO usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public LocalDateTime getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(LocalDateTime fechaLog) {
        this.fechaLog = fechaLog;
    }

    public PaisDTO getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(PaisDTO paisDestino) {
        this.paisDestino = paisDestino;
    }

    public SucursalDTO getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(SucursalDTO sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }

    public List<EnvioDetDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<EnvioDetDTO> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "EnvioDTO [idEnvio=" + idEnvio + ", fechaEnvio=" + fechaEnvio
                + ", sucursal=" + sucursal + ", clienteRemitente="
                + clienteRemitente + ", clienteDestinatario="
                + clienteDestinatario + ", estado=" + estado
                + ", unidadNegocio=" + unidadNegocio + ", entregado="
                + entregado + ", usuario=" + usuario + ", usuarioLog="
                + usuarioLog + ", fechaLog=" + fechaLog + ", paisDestino="
                + paisDestino + ", sucursalDestino=" + sucursalDestino
                + ", detalles=" + detalles + "]";
    }

}
