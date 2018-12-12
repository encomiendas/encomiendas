package py.com.domainsoft.envios.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.common.base.MoreObjects;

public class ExistenciaComprobanteDTO {

    private Integer idExistenciaComprob;

    private EquipoDTO equipo;

    private TipoComprobanteDTO tipoComprobante;

    private Integer nroDesde;

    private Integer nroHasta;

    private LocalDate fechaInicioTimb;

    private LocalDate fechaFinTimb;

    private Boolean imprime;

    private LocalDateTime fechaLog;

    public Integer getIdExistenciaComprob() {
        return idExistenciaComprob;
    }

    public void setIdExistenciaComprob(Integer idExistenciaComprob) {
        this.idExistenciaComprob = idExistenciaComprob;
    }

    public EquipoDTO getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDTO equipo) {
        this.equipo = equipo;
    }

    public TipoComprobanteDTO getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobanteDTO tipoComprobante) {
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idExistenciaComprob", idExistenciaComprob)
                .add("equipo", equipo).add("nroDesde", nroDesde)
                .add("nroHasta", nroHasta)
                .add("fechaInicioTimb", fechaInicioTimb)
                .add("fechaFinTimb", fechaFinTimb).add("imprime", imprime)
                .add("fechaLog", fechaLog).toString();

    }
}
