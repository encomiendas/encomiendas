package py.com.domainsoft.envios.entities;

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

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.entities.SucursalEntity;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "equipo")
public class EquipoEntity {
    @Id
    @GenericGenerator(name = "equipoSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "equipo_id_equipo_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "equipoSequenceGenerator")

    @Column(name = "id_equipo")
    private Integer idEquipo;

    private String descripcion;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

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

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idEquipo == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EquipoEntity toCompare = (EquipoEntity) obj;
        return idEquipo.equals(toCompare.idEquipo);
    }

    @Override
    public int hashCode() {
        return idEquipo == null ? 0 : idEquipo.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idTipoComprobante", idEquipo)
                .add("descripcion", descripcion).add("sucursal", sucursal)
                .add("estado", estado).toString();
    }

    @PrePersist
    public void preSave() {
        this.fechaLog = LocalDateTime.now();
    }

}
