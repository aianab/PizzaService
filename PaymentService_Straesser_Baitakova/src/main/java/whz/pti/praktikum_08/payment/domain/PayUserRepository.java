package whz.pti.praktikum_08.payment.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource
public interface PayUserRepository extends JpaRepository<PayUser, Integer> {
    Optional<PayUser> findByLoginName(String name);
    Optional<PayUser> findByUserId(String userID);

//    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM PayUser c WHERE c.name = ?1 and c.state = 'available'")
//    boolean existsByNameAndAvailable(String name);

}
