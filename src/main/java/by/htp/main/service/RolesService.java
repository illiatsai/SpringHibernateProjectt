package by.htp.main.service;

import by.htp.main.entity.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> rolesList();
    Roles getRoleById(int id);
}
