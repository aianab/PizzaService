package whz.pti.praktikum_08.payment.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayUserRepository extends JpaRepository<PayUser, Integer> {
    Optional<PayUser> findByLoginName(String name);
    Optional<PayUser> findByUserId(String userID);

}
