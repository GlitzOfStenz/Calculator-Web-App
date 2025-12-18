package logz.register.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logz.register.Entity.User;
import logz.register.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userrepo;
	@PostMapping("/register")
	public String register(@RequestBody User user) {
	    if(userrepo.findByUsername(user.getUsername()) != null) {
	        return "User already registered";
	    }
	    userrepo.save(user);
	    return "User registered successfully";
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
	    User found = userrepo.findByUsername(user.getUsername());
	    if(found != null && found.getPassword().equals(user.getPassword())) {
	        return "Login Successful";
	    }
	    return "Invalid credentials!";
	}

}
