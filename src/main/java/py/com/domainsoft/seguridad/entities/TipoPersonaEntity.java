package py.com.domainsoft.seguridad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.entities.PaisEntity;

@Entity
@Table(name = "tipo_persona")
public class TipoPersonaEntity {

    @Id
    @GenericGenerator(name = "personaSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "tipo_persona_id_tipo_persona_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "personaSequenceGenerator")
    @Column(name = "id_tipo_persona")
    private Integer idTipoPersona;
    
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idTipoPersona == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PaisEntity toCompare = (PaisEntity) obj;
        return idTipoPersona.equals(toCompare.getId());
    }

    @Override
    public int hashCode() {
        return idTipoPersona == null ? 0 : idTipoPersona.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idTipoPersona", idTipoPersona)
                .add("descripcion", descripcion)
                .toString();
    }    
    
}
