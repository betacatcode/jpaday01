package com.ruin.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 解决实体管理工厂的浪费资源和耗时问题
 *  通过静态代码块的形式 当程序第一次访问此工具类时 创建一个公共的实体管理器
 */
public class JpaUtils {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
