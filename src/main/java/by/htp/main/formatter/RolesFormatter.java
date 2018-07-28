package by.htp.main.formatter;

import by.htp.main.entity.Roles;
import by.htp.main.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RolesFormatter implements Formatter<Roles> {

    @Autowired
    private RolesService rolesService;

    @Override
    public Roles parse(String roleId, Locale locale) throws ParseException {
        return rolesService.getRoleById(Integer.parseInt(roleId));
    }

    @Override
    public String print(Roles roles, Locale locale) {
        return roles.getRole().toString();
    }
}
