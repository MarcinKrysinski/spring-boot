package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private String email;
    private String name;
    private String surname;

   public static AppUserDto create(AppUser user){
       return new AppUserDto(user.getEmail(), user.getName(), user.getSurname());
   }
}
