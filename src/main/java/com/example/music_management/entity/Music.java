//このクラスは、音楽のID、タイトル、再生時間、アルバムID、作成日時などの情報を保持します
package com.example.music_management.entity;

//@Data、LocalDateTimeクラス、LocalTimeクラス、@DateTimeFormatをインポートします
 import lombok.Data;
 import java.time.LocalDateTime;
 import java.time.LocalTime;
 import org.springframework.format.annotation.DateTimeFormat;

 //このアノテーションは、getter、setter、toString、equals、hashCodeメソッドを自動生成します
 @Data
public class Music {
    //musicId、titleフィールドを定義
    private long musicId;
    private String title;
    //このアノテーションは、durationフィールドの形式を"HH:mm:ss"に指定します
    @DateTimeFormat(pattern="HH:mm:ss")
    //duration、albumId、createdAtフィールドを定義
    private LocalTime duration;
    private long albumId;
    private LocalDateTime createdAt;
    
}
