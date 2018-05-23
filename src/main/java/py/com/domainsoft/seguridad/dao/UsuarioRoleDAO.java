package py.com.domainsoft.seguridad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.domainsoft.seguridad.entities.UsuarioRoleEntity;

@Repository
@Transactional
public class UsuarioRoleDAO {

    @Autowired
    private EntityManager entityManager;
 
    public List<String> getRoleNames(Integer userId) {
        String sql = "Select ur.roles.role from " + UsuarioRoleEntity.class.getName() + " ur " //
                + " where ur.usuario.id = :userId ";
 
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        
        return query.getResultList();
    }
    
    

}
