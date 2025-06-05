//このクラスはアルバムのID、タイトル、アーティスト、リリース日、作成日などの情報を保持します
package com.example.music_management.entity;
//@Data、@DateTimeFormatアノテーションをインポートします
 import lombok.Data;
 import org.springframework.format.annotation.DateTimeFormat;

//LocalDateクラス、LocalDateTimeクラスをインポートします
 import java.time.LocalDate;
 import java.time.LocalDateTime;


//@Data: このアノテーションは、getter、setter、toString、equals、hashCodeメソッドを自動生成します
@Data
public class Album {
   //albumId、title、artistフィールドを定義
   private long albumId;
   private String title;
   private String artist;

   //releaseDateフィールドの形式を"yyyy-MM-dd"に指定します
   @DateTimeFormat(pattern = "yyyy-MM-dd")

   //releaseDate、createdAtフィールドを定義
   private LocalDate releaseDate;
   private LocalDateTime createdAt;
   
}
