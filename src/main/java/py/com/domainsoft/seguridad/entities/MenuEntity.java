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
@Table(name = "menu")
public class MenuEntity {

    @Id
    @GenericGenerator(name = "menuSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "menu_id_menu_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "menuSequenceGenerator")
    @Column(name = "id_menu")
    private Integer idMenu;
    
    private String descripcion;
    
    private String tipoMenu;
    
    private Integer posicion;
    
    @ManyToOne(targetEntity = PerfilEntity.class)
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;
    
    @ManyToOne(targetEntity = PaginaEntity.class)
    @JoinColumn(name = "id_pagina")
    private PaginaEntity pagina;
    
    @ManyToOne(targetEntity = MenuEntity.class)
    @JoinColumn(name = "id_menu_anterior")
    private MenuEntity menuAnterior;
    
    private Boolean estado;
    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public MenuEntity getMenuAnterior() {
        return menuAnterior;
    }

    public void setMenuAnterior(MenuEntity menuAnterior) {
        this.menuAnterior = menuAnterior;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public PaginaEntity getPagina() {
        return pagina;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public void setPagina(PaginaEntity pagina) {
        this.pagina = pagina;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idMenu == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MenuEntity toCompare = (MenuEntity) obj;
        return idMenu.equals(toCompare.idMenu);
    }

    @Override
    public int hashCode() {
        return idMenu == null ? 0 : idMenu.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idMenu", idMenu)
                .add("tipoMenu", tipoMenu)
                .add("posicion", posicion)
                .add("perfil", perfil)
                .add("pagina", pagina)
                .add("menuAnterior", menuAnterior)
                .toString();
    }
    
}
