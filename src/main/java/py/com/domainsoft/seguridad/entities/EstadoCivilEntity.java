package py.com.domainsoft.seguridad.entities;

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
@Table(name = "estado_civil")
public class EstadoCivilEntity {

    @Id
    @GenericGenerator(name = "estadoCivilSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "estado_civil_id_estado_civil_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "estadoCivilSequenceGenerator")
    @Column(name = "id_estado_civil")
    private Integer idEstadoCivil;
    
    private String descripcion;
    
    private Boolean estado;

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (idEstadoCivil == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EstadoCivilEntity toCompare = (EstadoCivilEntity) obj;
        return idEstadoCivil.equals(toCompare.idEstadoCivil);
    }

    @Override
    public int hashCode() {
        return idEstadoCivil == null ? 0 : idEstadoCivil.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idEstadoCivil", idEstadoCivil)
                .add("descripcion", descripcion)
                .add("estado", estado)
                .toString();
    }  
    
}
