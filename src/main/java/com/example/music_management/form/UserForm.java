//このクラスは、ユーザーのユーザー名とパスワードなどの情報を保持します。
package com.example.music_management.form;
//@Dataアノテーションをインポートします
import lombok.Data;

//@Dataアノテーションを使用して、getter、setter、toString、equals、hashCodeメソッドを自動生成します
@Data
public class UserForm {
    //username,passwordフィールドを定義
    private String username;
    private String password;
}
