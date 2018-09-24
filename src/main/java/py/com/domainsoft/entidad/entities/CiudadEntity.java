package py.com.domainsoft.entidad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "ciudad")
public class CiudadEntity {

    @Id
    @GenericGenerator(name = "ciudadSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "ciudad_id_ciudad_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "ciudadSequenceGenerator")
    @Column(name = "id_ciudad")
    private Integer idCiudad;
    
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne(targetEntity = DivisionPoliticaEntity.class)
    @JoinColumn(name = "id_division_politica")
    private DivisionPoliticaEntity divisionPolitica;
    
    @Column(name = "estado")
    private boolean estado;

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idCiudad == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CiudadEntity toCompare = (CiudadEntity) obj;
        return idCiudad.equals(toCompare.idCiudad);
    }

    @Override
    public int hashCode() {
        return idCiudad == null ? 0 : idCiudad.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idCiudad", idCiudad)
                .add("descripcion", descripcion)
                .add("divisionPolitica", divisionPolitica)
                .add("estado", estado)
                .toString();
    }
}
