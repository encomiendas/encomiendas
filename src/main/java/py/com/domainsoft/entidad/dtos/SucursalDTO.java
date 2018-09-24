package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class SucursalDTO {

    private Integer idSucursal;

    private String descripcion;
    
    private EmpresaDTO empresa;
    
    private boolean estado;
    
    public Integer getIdSucursal() {
        return idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
       return MoreObjects.toStringHelper(this)
              .add("idSucursal", idSucursal)
              .add("descripcion", descripcion)
              .add("empresa", empresa)
              .add("estado", estado)
              .toString();
    }
    
}