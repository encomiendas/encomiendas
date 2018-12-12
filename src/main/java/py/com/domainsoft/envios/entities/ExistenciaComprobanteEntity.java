package py.com.domainsoft.envios.entities;

import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.entities.UsuarioEntity;

@Entity
@Table(name = "existencia_comprobante")
public class ExistenciaComprobanteEntity {

    @Id
    @GenericGenerator(name = "existenciaSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "existencia_comprobante_id_existencia_comprob_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "existenciaSequenceGenerator")

    @Column(name = "id_existencia_comprob")
    private Integer idExistenciaComprob;

    @ManyToOne(targetEntity = EquipoEntity.class)
    @JoinColumn(name = "id_equipo")
    private EquipoEntity equipo;

    @ManyToOne(targetEntity = TipoComprobanteEntity.class)
    @JoinColumn(name = "id_tipo_comprobante")
    private TipoComprobanteEntity tipoComprobante;

    private Integer nroDesde;

    private Integer nroHasta;
    
    private Integer nroTimbrado;

    private LocalDate fechaInicioTimb;

    private LocalDate fechaFinTimb;

    private Boolean imprime;

    private LocalDateTime fechaLog;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario_log")
    private UsuarioEntity usuario;

    public Integer getIdExistenciaComprob() {
        return idExistenciaComprob;
    }

    public void setIdExistenciaComprob(Integer idExistenciaComprob) {
        this.idExistenciaComprob = idExistenciaComprob;
    }

    public EquipoEntity getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntity equipo) {
        this.equipo = equipo;
    }

    public TipoComprobanteEntity getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobanteEntity tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Integer getNroDesde() {
        return nroDesde;
    }

    public void setNroDesde(Integer nroDesde) {
        this.nroDesde = nroDesde;
    }

    public Integer getNroHasta() {
        return nroHasta;
    }

    public void setNroHasta(Integer nroHasta) {
        this.nroHasta = nroHasta;
    }

    public LocalDate getFechaInicioTimb() {
        return fechaInicioTimb;
    }

    public void setFechaInicioTimb(LocalDate fechaInicioTimb) {
        this.fechaInicioTimb = fechaInicioTimb;
    }

    public LocalDate getFechaFinTimb() {
        return fechaFinTimb;
    }

    public void setFechaFinTimb(LocalDate fechaFinTimb) {
        this.fechaFinTimb = fechaFinTimb;
    }

    public Boolean getImprime() {
        return imprime;
    }

    public void setImprime(Boolean imprime) {
        this.imprime = imprime;
    }

    public LocalDateTime getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(LocalDateTime fechaLog) {
        this.fechaLog = fechaLog;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    

    public Integer getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(Integer nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idExistenciaComprob == null || obj == null
                || getClass() != obj.getClass()) {
            return false;
        }
        ExistenciaComprobanteEntity toCompare = (ExistenciaComprobanteEntity) obj;
        return idExistenciaComprob.equals(toCompare.idExistenciaComprob);
    }

    @Override
    public int hashCode() {
        return idExistenciaComprob == null ? 0 : idExistenciaComprob.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idExistenciaComprob", idExistenciaComprob)
                .add("tipoComprobante", tipoComprobante).add("equipo", equipo)
                .add("nroDesde", nroDesde).add("nroHasta", nroHasta)
                .add("fechaInicioTimb", fechaInicioTimb)
                .add("fechaFinTimb", fechaFinTimb).add("imprime", imprime)
                .add("usuario", usuario).add("nroTimbrado", nroTimbrado)
                .add("fechaLog", fechaLog).toString();

    }

    @PrePersist
    public void preSave() {
        this.fechaLog = LocalDateTime.now();
    }

}
