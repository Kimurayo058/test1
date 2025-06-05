//ログインページの表示を処理するコントローラー
package com.example.music_management.controller;
//@Controllerと@GetMappingアノテーションをインポートします
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;

//ログインコントローラークラスを定義、loginメソッドは、loginビューを返します、ユーザーが/loginパスにアクセスした際にログインページを表示する
@Controller
public class LoginController {
     @GetMapping("/login")
    public String login() {
        return "login";
    }
}
