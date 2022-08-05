package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.ERole;
import lb.applicationstage.locationvoiture.entities.Role;
import lb.applicationstage.locationvoiture.entities.User;
import lb.applicationstage.locationvoiture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User listUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User user){
        userRepository.save(user);

    }

    public List<User> getList(){
        return    userRepository.findAll();}
    public void adminUser (Long id)
    {
        User user =userRepository.findById(id).orElse(null);
        Role role=new Role();
        role.setName(ERole.ROLE_ADMIN);
        Set<Role> roles= new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

}