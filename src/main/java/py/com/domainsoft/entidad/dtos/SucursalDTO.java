package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

public class SucursalDTO {

    private Integer idSucursal;

    private String descripcion;
    
    private EmpresaDTO empresa;
    
    public SucursalDTO() {}

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
    
    @Override
    public String toString() {
       return MoreObjects.toStringHelper(this)
              .add("idSucursal", idSucursal)
              .add("descripcion", descripcion)
              .add("empresa", empresa)
              .toString();
    }
    
}