//このクラスは、Spring SecurityのUserDetailsServiceインターフェースを実装し、アプリケーション固有のユーザー詳細をロードします。UserRepositoryを使用してデータベースからユーザー情報を取得し、CustomUserDetailsオブジェクトを返します
package com.example.music_management.security;
//インポート
 import com.example.music_management.entity.User;
 import com.example.music_management.repository.UserRepository;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;
 //このアノテーションは、このクラスがSpringのサービス Bean として機能することを示します
@Service
public class CustomUserDetailsService implements UserDetailsService {
    //UserRepositoryのフィールド
     private final UserRepository userRepository;
     //CustomUserDetailsServiceのコンストラクタ
        public CustomUserDetailsService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
        //UserDetailsServiceインターフェースのloadUserByUsernameメソッドをオーバーライドし、指定されたユーザー名のユーザー詳細をロードします。
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.selectUserByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("user not found");
            }
            return new CustomUserDetails(user);
        }
}
