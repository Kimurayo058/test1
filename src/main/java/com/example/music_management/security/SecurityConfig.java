// このクラスは、Spring Securityの設定を定義するクラスとして機能します。HTTPリクエストの認可、フォームログインの設定、PasswordEncoderの設定を行います。
package com.example.music_management.security;
    //インポート
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;

//このアノテーションは、このクラスがSpringの設定クラスであることを示します
 @Configuration
public class SecurityConfig {
        //SecurityFilterChain Beanを定義し、HTTPリクエストの認可ルールを設定します
        @Bean
         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
             http
            .authorizeHttpRequests(request -> request
                .requestMatchers("/register", "/login", "/error").permitAll()
                .anyRequest().authenticated())
            .formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/albums")
                .failureUrl("/login?error")
                .permitAll()
            );
        return http.build();
        }
        //PasswordEncoder Beanを定義し、BCryptPasswordEncoderインスタンスを返します
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

}
