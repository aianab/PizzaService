package whz.pti.praktikum_08.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whz.pti.praktikum_08.payment.domain.Account;
import whz.pti.praktikum_08.payment.domain.PayUser;
import whz.pti.praktikum_08.payment.domain.PayUserRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class PayUserServiceImpl implements PayUserService {

    private static final Logger log = LoggerFactory.getLogger(PayUserServiceImpl.class);

    @Autowired
    private PayUserRepository payUserRepository;

    @Override
    public int getAccountBalanceByUserId(String userId) {
        PayUser payUser = null;
        try {
            payUser = payUserRepository.findByUserId(userId).orElseThrow(() -> new PayUserException("user cannot be found"));
        } catch (PayUserException e) {
            e.printStackTrace();
            return -101010;
        }
        return payUser.getAccount().getBalance();
    }


    @Override
    public String openAccount(String userId, String loginName) {
        PayUser payUser = new PayUser(userId, loginName);
        payUserRepository.save(payUser);
        if(payUserRepository.findByUserId(userId).get() != null) {
        	return "created";
        }else return "userNotCreated";
    }

    @Override
    @Transactional
    public String payForOrder(String userId, int amount) {
    	PayUser payUser = payUserRepository.findByUserId(userId)
                .orElseThrow(() -> new PayUserException("User " + userId + " not found"));
        Account userAccount = payUser.getAccount();
        if (userAccount.getBalance() >= amount) {
            userAccount.withdrawBalance(amount);
            payUserRepository.save(payUser);
            return "okay";
        } else return "notEnoughFunds";

    }

    @Override
    public PayUser getPayUser(String userId) {
        Optional<PayUser> userPayOptional = payUserRepository.findByUserId(userId);
        if (userPayOptional.isPresent()) {
            PayUser payUser = userPayOptional.get();
            return payUser;
        }
        ;
        return null;
    }

    @Override
    public String uploadMoney(String userId, int amount) throws PayUserException {
        PayUser payUser = payUserRepository.findByUserId(userId).orElseThrow(() -> new PayUserException("user cannot be found"));
        Account userAccount = payUser.getAccount();
        userAccount.depositBalance(amount);
        payUserRepository.save(payUser);
        return "success";
    }
}