package py.com.domainsoft.seguridad.entities;

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
@Table(name = "perfil_usuario")
public class PerfilUsuarioEntity {

    @Id
    @GenericGenerator(name = "perfilUsuarioSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "perfil_usuario_id_perfil_usuario_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "perfilUsuarioSequenceGenerator")
    @Column(name = "id_perfil_usuario")
    private Integer idPerfilUsuario;
    
    @ManyToOne(targetEntity = PerfilEntity.class)
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;
    
    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    public Integer getIdPerfilUsuario() {
        return idPerfilUsuario;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setIdPerfilUsuario(Integer idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idPerfilUsuario == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PerfilUsuarioEntity toCompare = (PerfilUsuarioEntity) obj;
        return idPerfilUsuario.equals(toCompare.idPerfilUsuario);
    }

    @Override
    public int hashCode() {
        return idPerfilUsuario == null ? 0 : idPerfilUsuario.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPerfilUsuario", idPerfilUsuario)
                .add("perfil", perfil)
                .add("usuario", usuario)
                .toString();
    }
    
}
