package by.htp.main.entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_customer")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@ManyToOne(optional=false)
	@JoinColumn(name="role", referencedColumnName = "id_role", nullable = false)
	private Roles role;

	/*@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Roles> roleOptions;*/
	
	public Customer() {
	}


	/*public List<Roles> getRoleOptions() {
		return roleOptions;
	}

	public void setRoleOptions(List<Roles> roleOptions) {
		this.roleOptions = roleOptions;
	}*/

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", role=" + role.getId() + " " +role.getRole() +
				'}';
	}
}





