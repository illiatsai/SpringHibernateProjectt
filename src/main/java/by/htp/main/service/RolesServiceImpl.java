package by.htp.main.service;

import by.htp.main.dao.RolesDAO;
import by.htp.main.dao.RolesDAOImpl;
import by.htp.main.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDAO rolesDAO;

    @Transactional
    public List<Roles> rolesList() {
        return rolesDAO.rolesList();
    }

    @Override
    public Roles getRoleById(int id) {
        return rolesDAO.getRoleById(id);
    }
}
