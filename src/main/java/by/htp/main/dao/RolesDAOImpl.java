package by.htp.main.dao;

import by.htp.main.entity.Customer;
import by.htp.main.entity.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolesDAOImpl implements RolesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //@Override
    public List<Roles> rolesList() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Roles> theQuery =
                currentSession.createQuery("from Roles",
                        Roles.class);

        List<Roles> roles = theQuery.getResultList();

        for(Roles role: roles) {
            System.out.println(role.toString());
        }

        return roles;
    }

    @Override
    public Roles getRoleById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Roles role = currentSession.get(Roles.class, id);

        return role;
    }
}
