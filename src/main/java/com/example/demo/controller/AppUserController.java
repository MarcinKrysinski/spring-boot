package com.example.demo.controller;


import com.example.demo.model.AppUser;
import com.example.demo.model.AppUserDto;
import com.example.demo.model.EditAppUserDto;
import com.example.demo.model.RegisterAppUserDto;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/registerUser")
    public ResponseEntity<AppUserDto> registerUser(@RequestBody RegisterAppUserDto registerUser) {
        AppUserDto registeredUser = appUserService.registerAppUser(registerUser);

        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<AppUserDto>> listUsers() {
        return ResponseEntity.ok(appUserService.listUsers());
    }

    @PostMapping("/editUser/{identifier}")
    public ResponseEntity<AppUserDto> editAppUser(@PathVariable(name = "identifier") Long id,
                                                  @RequestBody EditAppUserDto editAppUserDto) {
        Optional<AppUser> appUser = appUserService.editUser(id, editAppUserDto);

        if (appUser.isPresent()) {
            return ResponseEntity.ok(AppUserDto.create(appUser.get()));
        }

        return ResponseEntity.badRequest().build();
    }
}
