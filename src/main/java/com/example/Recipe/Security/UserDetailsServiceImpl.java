package com.example.Recipe.Security;

import com.example.Recipe.Models.Ingredient;
import com.example.Recipe.Models.RecipeModel;
import com.example.Recipe.Repositories.IngredientRepository;
import com.example.Recipe.Repositories.RecipeRepository;
import com.example.Recipe.Repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        UserAppRepository userAppRepository;

        @Autowired
        RecipeRepository RecipeRepository;

        @Autowired
        IngredientRepository IngredientRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return userAppRepository.findByUsername(username);
        }


        public Set<RecipeModel> getByKeyword(String keyword){
            return RecipeRepository.search(keyword);
        }



        public Set<RecipeModel> getByIngredientKeyword(String keyword){
            return RecipeRepository.searchIngredient(keyword);
        }

       // TODO: 4/20/2022
        public int updateUsersInfo(String username, String password, String first_name,
                               String last_name, Date date_of_birth, String nationality, String bio, Integer id){

        return userAppRepository.updateUserInfo(username, password, first_name, last_name, date_of_birth, nationality, bio, id);
    }


}
