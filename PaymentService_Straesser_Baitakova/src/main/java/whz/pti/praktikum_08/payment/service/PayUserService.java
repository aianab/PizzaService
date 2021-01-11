package whz.pti.praktikum_08.payment.service;

import whz.pti.praktikum_08.payment.domain.PayUser;

public interface PayUserService {
    int getAccountBalanceByUserId(String userId);

//    boolean containsAndAvailable(String userId);

//    State getState(String userId);

    String openAccount(String userId, String loginName);

    String uploadMoney(String userId, int amount) throws PayUserException;

    String payForOrder(String userId, int amount);

//    void changeUserToSuspendedState(String userId);

    PayUser getPayUser(String userId);
}
