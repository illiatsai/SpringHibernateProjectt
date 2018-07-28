package by.htp.main.editor;


import by.htp.main.entity.Customer;
import by.htp.main.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CustomerEditor extends PropertyEditorSupport {

    @Autowired
    private CustomerService customerService;

    @Override
    public void setAsText(String id)
    {
        Customer c = customerService.getCustomer(Integer.parseInt(id));
        this.setValue(c);
    }

}
