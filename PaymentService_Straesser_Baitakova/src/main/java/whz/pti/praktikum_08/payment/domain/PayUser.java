package whz.pti.praktikum_08.payment.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import whz.pti.praktikum_08.payment.common.BaseEntity;
import javax.persistence.*;

@Entity
public class PayUser extends BaseEntity<Long> {
	
    private String loginName;
    private String userId;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public PayUser() {
        account = new Account();
    }

    public PayUser (String userId, String loginName) {
        account = new Account();
        this.loginName = loginName;
        this.userId = userId;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return loginName;
    }

    public void setName(String name) {
        this.loginName = name;
    }

    public Account getAccount() {
        return account;
    }


    @Override
    public String toString() {
        return " [ " +
                getId() + " , " +
        userId + " , "	+	
        loginName + " , " +
        account.toString() + " ]"
                ;
    }
}


