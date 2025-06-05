//アプリケーションのパッケージの設定
package com.example.music_management;

//SpringApplicationクラスをインポート
import org.springframework.boot.SpringApplication;
//@SpringBootApplicationアノテーションをインポート
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring Bootアプリケーションであることを示し、自動設定、コンポーネントスキャン、および他のSpring Boot機能を有効にします
@SpringBootApplication
public class MusicManagementApplication {

	//SpringApplicationクラスのrunメソッドを呼び出して、Spring Bootアプリケーションを起動します
	public static void main(String[] args) {
		SpringApplication.run(MusicManagementApplication.class, args);
	}

}
