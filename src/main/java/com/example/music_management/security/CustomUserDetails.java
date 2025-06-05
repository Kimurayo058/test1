//このクラスは、Spring SecurityのUserDetailsインターフェースを実装し、アプリケーション固有のユーザー詳細を提供します。Userエンティティからユーザーの情報を取得して、Spring Securityが必要な情報を取得できるようにします。
package com.example.music_management.security;
//インポート
 import com.example.music_management.entity.User;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;
 import java.util.Collection;
//Listをインポート
 import java.util.List;
//CustomUserDetailsクラスを定義し、UserDetailsインターフェースを実装
public class CustomUserDetails implements UserDetails {
    //Userフィールド
    private final User user;
        //CustomUserDetailsコンストラクタ
        public CustomUserDetails(User user) {
            this.user = user;
        }
        //ユーザーの権限（ロール）を取得するメソッドを定義します。現時点では権限を定義していないため、空のリストを返します
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of();
        }
        //ユーザーのパスワードを取得するメソッドを定義します。Userエンティティからパスワードを取得
        @Override
        public String getPassword() {
            return user.getPassword();
        }
        //ユーザーのユーザー名を取得するメソッドを定義します。Userエンティティからユーザー名を取得
        @Override
        public String getUsername() {
            return user.getUsername();
        }
 }
