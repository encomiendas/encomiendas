package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class EmpresaDTO {

    private Integer idEmpresa;

    private String descripcion;

    private String nroDocumento;

    private String direccion;

    private String telefono;

    private Boolean estado;
    
    public EmpresaDTO() {}

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
       return MoreObjects.toStringHelper(this)
              .add("idEmpresa", idEmpresa)
              .add("descripcion", descripcion)
              .add("nroDocumento", nroDocumento)
              .add("direccion", direccion)
              .add("telefono", telefono)
              .add("estado", estado)
              .toString();
    }

}