package by.htp.main.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;
import javax.validation.Valid;

import by.htp.main.editor.CustomerEditor;
import by.htp.main.editor.RolesEditor;
import by.htp.main.entity.Roles;
import by.htp.main.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import by.htp.main.entity.Customer;
import by.htp.main.service.CustomerService;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/main/customer")
@SessionAttributes(types = Customer.class)
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;

	@Autowired
	private RolesService rolesService;

	/*private Validator validator;*/

	/*public CustomerController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}*/

	/*@Autowired
	private ConversionService conversionService;
	//Autowiring the ConversionService we declared in the context file above.*/

	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Roles.class, new RolesEditor());
	}*/

	/*@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Customer.class, new CustomerEditor());
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}*/

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {

		binder.registerCustomEditor(Roles.class, "role", new PropertyEditorSupport() {

			public void setAsText(String text) {
				int roleId = Integer.parseInt(text);
				Roles role = rolesService.getRoleById(roleId);
				setValue(role);
			}
		});

	}

	@ModelAttribute("rolesOptions")
	public List<Roles> listAllRoles()
	{
		List<Roles> rolesOptions = rolesService.rolesList();

		return rolesOptions;
	}
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();

		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}


	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer,
							 BindingResult result, SessionStatus status) {

		// Store the employee information in database
		customerService.saveCustomer(customer);

		// Mark Session Complete
		status.setComplete();
		return "redirect:/main/customer/list";
	}

	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);

		/*List<Roles> theRoles = rolesService.rolesList();

		theCustomer.setRoleOptions(theRoles);*/
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/main/customer/list";
	}
}










