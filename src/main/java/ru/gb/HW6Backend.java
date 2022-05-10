package ru.gb;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.gb.entity.CityEntity;
import ru.gb.entity.ProductEntity;
import ru.gb.entity.UsersEntity;


import javax.persistence.metamodel.EntityType;

public class HW6Backend {

        private static final SessionFactory ourSessionFactory;

        static {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                ourSessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw  new ExceptionInInitializerError(ex);
            }
        }

        public static Session getSession() throws HibernateException {
            return ourSessionFactory.openSession();
        }

        public static void main(final String[] args) throws Exception {
            try (Session session = getSession()) {
               UsersEntity usersEntity = new UsersEntity();
               usersEntity.setUserId(1234567);
               usersEntity.setName("User 1234567");
               session.save(usersEntity);
               System.out.println(session.get(UsersEntity.class, usersEntity.getUserId()));
               usersEntity.setName(usersEntity.getName() + " changed");
               session.update(usersEntity);
               System.out.println(session.get(UsersEntity.class, usersEntity.getUserId()));
               session.delete(usersEntity);
               System.out.println(session.get(UsersEntity.class, usersEntity.getUserId()));
/*
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCityId(765);
                cityEntity.setCityName("Kyky");
                cityEntity.setCountryId(321);
                session.save(cityEntity);
                System.out.println(session.get(CityEntity.class, cityEntity.getCityId()));
                cityEntity.setCityName(cityEntity.getCityName() + "oooo");
                session.update(cityEntity);
                System.out.println(session.get(CityEntity.class, cityEntity.getCityId()));
                session.delete(cityEntity);
                System.out.println(session.get(CityEntity.class, cityEntity.getCityId()));

                ProductEntity productEntity = new ProductEntity();  // создаем UsersEntity
                productEntity.setProductId(765);
                productEntity.setName("Сhuck-chuck");
                session.save(productEntity);
                System.out.println(session.get(ProductEntity.class, productEntity.getProductId()));
                productEntity.setName(productEntity.getName() + "432");
                session.update(productEntity);
                System.out.println(session.get(ProductEntity.class, productEntity.getProductId()));
                session.delete(productEntity);
                System.out.println(session.get(ProductEntity.class, productEntity.getProductId()));
*/

//            System.out.println(session.get(UsersEntity.class, 1).getSalesByUserId().stream()
  //                  .findAny().orElseThrow().getSaleId());

            }
        }
}
