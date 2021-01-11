package whz.pti.praktikum_08.payment.service;

import whz.pti.praktikum_08.payment.domain.PayUser;

public interface PayUserService {
    int getAccountBalanceByUserId(String userId);

    String openAccount(String userId, String loginName);

    String uploadMoney(String userId, int amount) throws PayUserException;

    String payForOrder(String userId, int amount);

    PayUser getPayUser(String userId);
}
