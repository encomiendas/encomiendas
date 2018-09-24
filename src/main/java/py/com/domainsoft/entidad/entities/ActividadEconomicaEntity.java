package py.com.domainsoft.entidad.entities;

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

@Entity
@Table(name = "actividad_economica")
public class ActividadEconomicaEntity {

    @Id
    @GenericGenerator(name = "actividadEconomicaSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "actividad_economica_id_actividad_economica_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "actividadEconomicaSequenceGenerator")
    @Column(name = "id_actividad_economica")
    private Integer idActividadEconomica;
    
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private boolean estado;

    public Integer getIdActividadEconomica() {
        return idActividadEconomica;
    }

    public void setIdActividadEconomica(Integer idActividadEconomica) {
        this.idActividadEconomica = idActividadEconomica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idActividadEconomica == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActividadEconomicaEntity toCompare = (ActividadEconomicaEntity) obj;
        return idActividadEconomica.equals(toCompare.idActividadEconomica);
    }

    @Override
    public int hashCode() {
        return idActividadEconomica == null ? 0 : idActividadEconomica.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idActividadEconomica", idActividadEconomica)
                .add("descripcion", descripcion)
                .add("estado", estado)
                .toString();
    }
}
