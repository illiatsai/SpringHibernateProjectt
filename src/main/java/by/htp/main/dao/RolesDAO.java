package by.htp.main.dao;

import by.htp.main.entity.Roles;

import java.util.List;

public interface RolesDAO {
    List<Roles> rolesList();
    Roles getRoleById(int id);
}
