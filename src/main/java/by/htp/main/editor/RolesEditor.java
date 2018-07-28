package by.htp.main.editor;

import by.htp.main.entity.Roles;
import by.htp.main.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {

    @Autowired
    private RolesService rolesService;

    @Override
    public void setAsText(String id)
    {
        Roles r = rolesService.getRoleById(Integer.parseInt(id));
        this.setValue(r);
    }

}
