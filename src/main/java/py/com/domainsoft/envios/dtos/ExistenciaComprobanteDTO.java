package py.com.domainsoft.envios.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public class ExistenciaComprobanteDTO {

    private Integer idExistenciaComprob;

    private EquipoDTO equipo;

    private TipoComprobanteDTO tipoComprobante;

    private Integer nroDesde;

    private Integer nroHasta;

    private Integer nroTimbrado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaInicioTimb;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaFinTimb;

    private Boolean imprime;

    private LocalDateTime fechaLog;

    private UsuarioDTO usuario;

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

    public Integer getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(Integer nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public LocalDateTime getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(LocalDateTime fechaLog) {
        this.fechaLog = fechaLog;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
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
}
