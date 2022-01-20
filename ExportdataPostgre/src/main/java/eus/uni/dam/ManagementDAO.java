package eus.uni.dam;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;



@Repository
@Transactional  //Método bakoitza hasi aurretik transakzio bat hasiko da, metodoa bukatutakoan, transakzioa bukatu 
public class ManagementDAO {

    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los productos de la base de datos
     */
    @SuppressWarnings("unchecked")
    public List<PartidakPartidak> getPartidak() {
        return entityManager.createQuery("from PartidakPartidak").getResultList();
    }


    /**
     * Devuelve un producto en base a su Id 
     */
  
    
    
    public void create(PartidakPartidak p) {
        entityManager.persist(p);
        return;
    }
    
    public void update(PartidakPartidak p) {
    	entityManager.merge(p);
    }

    
 
    @SuppressWarnings("unchecked")
    public List<HrEmployee> getEmployees() {
        return entityManager.createQuery("from ResPartner").getResultList();
    }
    public HrEmployee getEmpById(long id) {
        return entityManager.find(HrEmployee.class, id);
    }
    public HrEmployee getEmpByDeparmentId(long departmentId) {
        return entityManager.find(HrEmployee.class, departmentId);
    }
    public void create(HrEmployee emp) {
        entityManager.persist(emp);
        return;
    }
    public void update(HrEmployee emp) {
    	entityManager.merge(emp);
    }
    
    
    
}

