package cn.ruin.test;

import com.ruin.domain.Customer;
import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author ruin
 * @date 2019/11/17-16:53
 */
public class JpaTest {

    /**
     * jpa操作步骤
     *  1.加载配置文件创建工厂
     *  2.通过工厂获得实体管理器
     *  3.获取事务对象 开启事务
     *  4.完成增删改查操作
     *  5.提交事务(回滚事务)
     *  6.释放资源
     */

    /**
     * 测试jpa的保存
     */

    @Test
    public void testSave(){
        //1.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");

        //2.
        EntityManager em=factory.createEntityManager();

        //3.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //4.
        Customer customer=new Customer();
        customer.setCustName("张三");
        customer.setCustIndustry("科院");

        //5.
        em.persist(customer);

        tx.commit();

        //6.
        em.close();
        factory.close();
    }
}
