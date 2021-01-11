package whz.pti.praktikum_08.payment.dto;

public class UserDTO {

    private String userId;
    private String userLogin;
    
    public UserDTO() {
    	
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public UserDTO(String userId, String userLogin) {
        this.userId = userId;
        this.userLogin = userLogin;
    }


}