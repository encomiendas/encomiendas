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
@Table(name = "pais")
public class PaisEntity {
	
	
    @Id
    @GenericGenerator(name = "paisSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "pais_id_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "paisSequenceGenerator")
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "gentilicio")
    private String gentilicio;
    
    @Column(name = "cod_pais_num")
    private Integer codPaisNum;
    
    @Column(name = "cod_pais_alfa2")
    private String codPaisAlfa2;

    @Column(name = "cod_pais_alfa3")
    private String codPaisAlfa3;
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGentilicio() {
		return gentilicio;
	}

	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}

	public Integer getCodPaisNum() {
		return codPaisNum;
	}

	public void setCodPaisNum(Integer codPaisNum) {
		this.codPaisNum = codPaisNum;
	}

	public String getCodPaisAlfa2() {
		return codPaisAlfa2;
	}

	public void setCodPaisAlfa2(String codPaisAlfa2) {
		this.codPaisAlfa2 = codPaisAlfa2;
	}
	
	public String getCodPaisAlfa3() {
        return codPaisAlfa3;
    }

    public void setCodPaisAlfa3(String codPaisAlfa3) {
        this.codPaisAlfa3 = codPaisAlfa3;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (id == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PaisEntity toCompare = (PaisEntity) obj;
        return id.equals(toCompare.id);
    }

	@Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
	
	@Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("descripcion", descripcion)
                .add("gentilicio", gentilicio)
                .add("codPaisNum", codPaisNum)
                .add("codPaisAlfa2", codPaisAlfa2)
                .add("codPaisAlfa3", codPaisAlfa3)
                .toString();
    }    
    
}
