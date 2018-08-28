package py.com.domainsoft.entidad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "empresa")
public class EmpresaEntity {

    @Id
    @GenericGenerator(name = "empresaSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "empresa_id_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "empresaSequenceGenerator")
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "nro_documento")
    private String nroDocumento;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
 
    @Column(name = "estado")
    private Boolean estado;

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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idEmpresa == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmpresaEntity toCompare = (EmpresaEntity) obj;
        return idEmpresa.equals(toCompare.idEmpresa);
    }

    @Override
    public int hashCode() {
        return idEmpresa == null ? 0 : idEmpresa.hashCode();
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
