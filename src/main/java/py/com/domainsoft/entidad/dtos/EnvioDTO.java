package py.com.domainsoft.entidad.dtos;

import java.time.LocalDateTime;
import java.util.List;

import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public class EnvioDTO {

    private Integer idEnvio;

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

    public EnvioDTO() {
    };

    public EnvioDTO(Integer idEnvio, 
            LocalDateTime fechaEnvio,
            SucursalDTO sucursal, ClienteDTO clienteRemitente,
            ClienteDTO clienteDestinatario, String estado,
            UnidadNegocioDTO unidadNegocio, String entregado,
            UsuarioDTO usuario, UsuarioDTO usuarioLog, LocalDateTime fechaLog,
            PaisDTO paisDestino, SucursalDTO sucursalDestino,
            List<EnvioDetDTO> detalles) {
        this.idEnvio = idEnvio;
        this.fechaEnvio = fechaEnvio;
        this.sucursal = sucursal;
        this.clienteRemitente = clienteRemitente;
        this.clienteDestinatario = clienteDestinatario;
        this.estado = estado;
        this.unidadNegocio = unidadNegocio;
        this.entregado = entregado;
        this.usuario = usuario;
        this.usuarioLog = usuarioLog;
        this.fechaLog = fechaLog;
        this.paisDestino = paisDestino;
        this.sucursalDestino = sucursalDestino;
        this.detalles = detalles;
    }

    public static class Builder {

        private Integer idEnvio;
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

        public Builder idEnvio(Integer idEnvio) {
            this.idEnvio = idEnvio;
            return this;
        }

        public Builder fechaEnvio(LocalDateTime fechaEnvio) {
            this.fechaEnvio = fechaEnvio;
            return this;
        }

        public Builder sucursal(SucursalDTO sucursal) {
            this.sucursal = sucursal;
            return this;
        }

        public Builder clienteRemitente(ClienteDTO clienteRemitente) {
            this.clienteRemitente = clienteRemitente;
            return this;
        }

        public Builder clienteDestinatario(ClienteDTO clienteRemitente) {
            this.clienteRemitente = clienteRemitente;
            return this;
        }

        public Builder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder unidadNegocio(UnidadNegocioDTO unidadNegocio) {
            this.unidadNegocio = unidadNegocio;
            return this;
        }

        public Builder entregado(String entregado) {
            this.entregado = entregado;
            return this;
        }

        public Builder usuario(UsuarioDTO usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder usuarioLog(UsuarioDTO usuarioLog) {
            this.usuarioLog = usuarioLog;
            return this;
        }

        public Builder fechaLog(LocalDateTime fechaLog) {
            this.fechaLog = fechaLog;
            return this;
        }

        public Builder paisDestino(PaisDTO paisDestino) {
            this.paisDestino = paisDestino;
            return this;
        }

        public Builder sucursalDestino(SucursalDTO sucursalDestino) {
            this.sucursalDestino = sucursalDestino;
            return this;
        }

        public Builder detalles(List<EnvioDetDTO> detalles) {
            this.detalles = detalles;
            return this;
        }

        public EnvioDTO build() {
            return new EnvioDTO(idEnvio, fechaEnvio, sucursal, clienteRemitente,
                    clienteDestinatario, estado, unidadNegocio, entregado,
                    usuario, usuarioLog, fechaLog, paisDestino, sucursalDestino,
                    detalles);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

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
