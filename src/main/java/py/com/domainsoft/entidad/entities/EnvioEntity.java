package py.com.domainsoft.entidad.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.domainsoft.envios.entities.UnidadNegocioEntity;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "envio")
public class EnvioEntity {

    @Id
    @GenericGenerator(name = "envioSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "envio_id_envio_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "envioSequenceGenerator")
    @Column(name = "id_envio")
    private Integer idEnvio;
    
    private LocalDateTime fechaEnvio;
    
    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;
    
    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "id_cliente_remitente")
    private ClienteEntity clienteRemitente;
    
    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "id_cliente_destinatario")
    private ClienteEntity clienteDestinatario;
    
    private String estado;
    
    @ManyToOne(targetEntity = UnidadNegocioEntity.class)
    @JoinColumn(name = "id_unidad_negocio")
    private UnidadNegocioEntity unidadNegocio;
    
    private String entregado;
    
    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
    
    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario_log")
    private UsuarioEntity usuarioLog;
    
    private LocalDateTime fechaLog;
    
    @ManyToOne(targetEntity = PaisEntity.class)
    @JoinColumn(name = "id_pais_destino")
    private PaisEntity paisDestino;
    
    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal_destino")
    private SucursalEntity sucursalDestino;

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

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public ClienteEntity getClienteRemitente() {
        return clienteRemitente;
    }

    public void setClienteRemitente(ClienteEntity clienteRemitente) {
        this.clienteRemitente = clienteRemitente;
    }

    public ClienteEntity getClienteDestinatario() {
        return clienteDestinatario;
    }

    public void setClienteDestinatario(ClienteEntity clienteDestinatario) {
        this.clienteDestinatario = clienteDestinatario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UnidadNegocioEntity getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(UnidadNegocioEntity unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public UsuarioEntity getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(UsuarioEntity usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public LocalDateTime getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(LocalDateTime fechaLog) {
        this.fechaLog = fechaLog;
    }

    public PaisEntity getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(PaisEntity paisDestino) {
        this.paisDestino = paisDestino;
    }

    public SucursalEntity getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(SucursalEntity sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idEnvio == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EnvioEntity toCompare = (EnvioEntity) obj;
        return idEnvio.equals(toCompare.idEnvio);
    }

    @Override
    public int hashCode() {
        return idEnvio == null ? 0 : idEnvio.hashCode();
    }
    
    
    @PrePersist
    public void preSave() {
        this.fechaLog = LocalDateTime.now();
    }  
    
}
