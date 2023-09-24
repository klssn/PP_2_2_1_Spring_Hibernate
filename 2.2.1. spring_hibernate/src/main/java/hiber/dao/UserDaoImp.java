package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@EnableTransactionManagement
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @Transactional
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   @Transactional(readOnly = true)
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserByCarModelAndSeries (String model,int series) {
      String hql = "SELECT users FROM User users JOIN users.car cars WHERE cars.model = :model AND cars.series = :series";
      return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("model", model).setParameter("series", series).uniqueResult();
   }
}
