package logz.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import logz.register.Entity.User;

public interface UserRepository  extends JpaRepository<User,Long> {
User findByUsername(String username);
}
