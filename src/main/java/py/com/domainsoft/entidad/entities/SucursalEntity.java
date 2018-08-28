package py.com.domainsoft.entidad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "sucursal")
public class SucursalEntity {
    
    @Id
    @GenericGenerator(name = "sucursalSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "sucursal_id_sucursal_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "sucursalSequenceGenerator")
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idSucursal == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SucursalEntity toCompare = (SucursalEntity) obj;
        return idSucursal.equals(toCompare.idSucursal);
    }

    @Override
    public int hashCode() {
        return idSucursal == null ? 0 : idSucursal.hashCode();
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
