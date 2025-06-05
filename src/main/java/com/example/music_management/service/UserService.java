//
package com.example.music_management.service;
//インポート
 import com.example.music_management.entity.User;
 import com.example.music_management.form.UserForm;
 import com.example.music_management.repository.UserRepository;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Service;

 //
 @Service
public class UserService {
  //UserRepository、PasswordEncoderのフィールド
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
        //UserServiceコンストラクタ
        public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
          this.userRepository = userRepository;
          this.passwordEncoder = passwordEncoder;
        }
        //新しいユーザーを作成し、データベースに保存する
        public void createUser(UserForm userForm) {
          User user = new User();
          user.setUsername(userForm.getUsername());
          String hashedPassword = passwordEncoder.encode(userForm.getPassword());
          user.setPassword(hashedPassword);
          userRepository.insertUser(user);
        }
}
