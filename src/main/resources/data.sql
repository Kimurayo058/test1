-- albumsテーブルにデータを挿入
INSERT INTO albums (title, artist, release_date) VALUES
  ('Hello World', 'Aurora Beats', '2021-08-20'),-- アルバム1のデータ
  ('Strings of Serenity', 'Harmony Collective', '2020-11-10'),-- アルバム2のデータ
  ('Cosmic Vibes', 'Galaxy Harmonics', '2024-01-18');-- アルバム3のデータ

  -- musicsテーブルにデータを挿入
 INSERT INTO musics (title, duration, album_id) VALUES
  ('Sunset', '00:03:45', 1),-- アルバム1に属する曲1のデータ
  ('Moonlight', '00:04:12', 1),-- アルバム1に属する曲2のデータ
  ('Eternal Memories', '00:05:45', 2);-- アルバム2に属する曲1のデータ
-- PW は「track」
-- usersテーブルにデータを挿入
INSERT INTO users (username, password) VALUES ('sample', '$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC');

