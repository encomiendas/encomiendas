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
@Table(name = "division_politica")
public class DivisionPoliticaEntity {

    @Id
    @GenericGenerator(name = "divisionPoliticaSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "division_politica_id_division_politica_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "divisionPoliticaSequenceGenerator")
    @Column(name = "id_division_politica")
    private Integer idDivisionPolitica;
    
    @ManyToOne(targetEntity = PaisEntity.class)
    @JoinColumn(name = "id_pais")
    private PaisEntity pais;
    
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private boolean estado;

    
    public Integer getIdDivisionPolitica() {
        return idDivisionPolitica;
    }

    public void setIdDivisionPolitica(Integer idDivisionPolitica) {
        this.idDivisionPolitica = idDivisionPolitica;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
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
        if (idDivisionPolitica == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DivisionPoliticaEntity toCompare = (DivisionPoliticaEntity) obj;
        return idDivisionPolitica.equals(toCompare.idDivisionPolitica);
    }

    @Override
    public int hashCode() {
        return idDivisionPolitica == null ? 0 : idDivisionPolitica.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idDivisionPolitica", idDivisionPolitica)
                .add("descripcion", descripcion)
                .add("pais", pais)
                .add("estado", estado)
                .toString();
    }
}
