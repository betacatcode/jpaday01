package cn.ruin.test;

import com.ruin.domain.Customer;
import com.ruin.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {

    /**
     * 查询全部
     */

    @Test
    public void findAll(){
        EntityManager em = JpaUtils.getEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String jpql="from Customer ";
        Query query = em.createQuery((jpql));

        List resultList = query.getResultList();

        for(Object obj:resultList)
            System.out.println(obj);

        tx.commit();

        em.close();

    }
}
