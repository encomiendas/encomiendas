package py.com.domainsoft.seguridad.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.domainsoft.seguridad.entities.UsuarioEntity;

@Repository
@Transactional
public class UsuarioDAO {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioDAO.class);

    private EntityManager entityManager;

    public UsuarioDAO(
            EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UsuarioEntity findUserAccount(String userName) {
        try {
            String sql = "Select e from " + UsuarioEntity.class.getName() + " e " //
                    + " Where e.login = :userName ";
 
            Query query = entityManager.createQuery(sql, UsuarioEntity.class);
            query.setParameter("userName", userName);
 
            return (UsuarioEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
