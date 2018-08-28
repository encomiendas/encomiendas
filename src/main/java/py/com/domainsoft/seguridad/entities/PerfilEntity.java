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
@Table(name = "perfil")
public class PerfilEntity {

    @Id
    @GenericGenerator(name = "perfilSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "perfil_id_perfil_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "perfilSequenceGenerator")
    @Column(name = "id_perfil")
    private Integer idPerfil;
    
    private String descripcion;

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idPerfil == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PerfilEntity toCompare = (PerfilEntity) obj;
        return idPerfil.equals(toCompare.idPerfil);
    }

    @Override
    public int hashCode() {
        return idPerfil == null ? 0 : idPerfil.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPerfil", idPerfil)
                .add("descripcion", descripcion)
                .toString();
    }  
    
}
