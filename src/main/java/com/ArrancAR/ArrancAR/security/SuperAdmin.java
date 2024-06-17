package com.ArrancAR.ArrancAR.security;

import com.ArrancAR.ArrancAR.entity.Role;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.repository.RoleRepository;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SuperAdmin implements ApplicationRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //crear un usuario como si fuese real

        BCryptPasswordEncoder cifrador= new BCryptPasswordEncoder();
        String passSinCifrar = "superadmin";
        String passCifrado = cifrador.encode(passSinCifrar);
        Role roleSuperAdmin = new Role(1L, "ROLE_SUPER_ADMIN", "SUPERADMIN");
        User userSuperAdmin = new User(1L, "Super", "superadmin", "Admin", passCifrado, "superadmin@gmail.com", roleRepository.save(roleSuperAdmin));
        userRepository.save(userSuperAdmin);

        String passSinCifrarAdmin = "admin";
        String passCifradoAdmin = cifrador.encode(passSinCifrarAdmin);
        Role roleAdmin = new Role(2L, "ROLE_ADMIN", "ADMIN");
        User userAdmin = new User(2L,"Standard", "admin", "Admin", passCifradoAdmin, "admin@gmail.com", roleRepository.save(roleAdmin));
        userRepository.save(userAdmin);

        String passSinCifrarUser = "user";
        String passCifradoUser = cifrador.encode(passSinCifrarUser);
        Role roleUser = new Role(3L, "ROLE_USER", "USER");
        User userUser = new User(3L, "Standard", "user", "User", passCifradoUser, "user@gmail.com", roleRepository.save(roleUser));
        userRepository.save(userUser);
    }



}
