package py.com.domainsoft.seguridad.entities;

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

@Entity
@Table(name = "usuarios_x_role")
public class UsuarioRoleEntity {
    
    @Id
    @GenericGenerator(name = "usuariosRoleSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "usuarios_x_role_id_usuario_x_role_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "usuariosRoleSequenceGenerator")
	@Column(name="id_usuario_x_role")
	private Integer id;
	
    @ManyToOne(targetEntity = RoleEntity.class)
    @JoinColumn(name = "id_role", nullable = false)
    private RoleEntity roles;
	
	@NotNull
    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEntity getRoles() {
        return roles;
    }

    public void setRoles(RoleEntity roles) {
        this.roles = roles;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
	
}
