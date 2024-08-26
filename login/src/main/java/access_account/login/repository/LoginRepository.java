package access_account.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import access_account.login.model.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, Long> {
    LoginModel findByUsername(String username);
    
}
