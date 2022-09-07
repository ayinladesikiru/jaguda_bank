package africa.semicolon.jaguda_bank.data.repository;

import africa.semicolon.jaguda_bank.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByAccountNumber(String accountNumber);
}
