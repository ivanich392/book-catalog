package com.bookcatalog.controller;

import com.bookcatalog.entity.Role;
import com.bookcatalog.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private static final Logger logger =
            LoggerFactory.getLogger(RoleController.class);

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public List<Role> getAllRoles() {

        logger.info("Getting all roles");

        return roleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {

        logger.info("Getting role by id: {}", id);

        return roleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Role not found"));
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {

        logger.info("Creating role: {}", role.getName());

        return roleRepository.save(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {

        logger.info("Deleting role with id: {}", id);

        roleRepository.deleteById(id);
    }
}