//ユーザー登録を処理するコントローラー: このクラスは、ユーザー登録フォームの表示とユーザー登録処理を担当する
package com.example.music_management.controller;
//UserServiceをコンストラクタで注入し、このサービスを使用する
//@GetMapping, @PostMappingなどのアノテーションをインポートし使用する
 import com.example.music_management.form.UserForm;
 import com.example.music_management.service.UserService;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;

 //登録コントローラークラスを定義
 @Controller
 public class RegistrationController {
    //UserServiceフィールドを定義
    private final UserService userService;

    //コンストラクタでUserServiceを注入
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    
    ///registerパスへのGETリクエストをshowRegistrationFormメソッドにマッピングします
    //showRegistrationFormメソッドは、空のUserFormオブジェクトを作成し、モデルに追加して、registerビューを返します
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    ///registerパスへのPOSTリクエストをregisterUserメソッドにマッピングします
    //registerUserメソッドは、UserServiceを使用して新しいユーザーを作成し、/login?registerにリダイレクトします
    @PostMapping("/register")
    public String registerUser(UserForm userForm) {
        userService.createUser(userForm);
        return "redirect:/login?register";
    }
}
