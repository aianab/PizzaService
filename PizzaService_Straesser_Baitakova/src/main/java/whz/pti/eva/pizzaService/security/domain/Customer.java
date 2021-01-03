package whz.pti.eva.pizzaService.security.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import whz.pti.eva.pizzaService.common.BaseEntity;

@Entity
@Table(name = "secuser")
public class Customer extends BaseEntity<Long>{

	@Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "loginName", nullable = false, unique = true)
    private String loginName;
    
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;

	@ManyToMany
	private List<DeliveryAddress> address;
    
	public Long getId() {
        return super.getId();
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
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    

    public String getPasswordHash() {
        return password;
    }

    public void setPasswordHash(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<DeliveryAddress> getDeliveryAddresses(){
    	return address;
   }
    
    public void addDeliveryAddress(DeliveryAddress deliveryAdress) {
    	this.address.add(deliveryAdress);
   }
    
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", loginName='" + loginName +
                ", password='" + password.substring(0, 10) +
                ", role=" + role +
                '}';
    }
}

