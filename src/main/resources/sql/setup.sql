--DDL
create table person
(
   person_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   name VARCHAR (50),
   age TINYINT,
   gender TINYINT, -- 選択なし：0, 男性：1, 女性：2;
   tel varchar (20),
   mail varchar (256),
   insert_user VARCHAR (50),
   insert_datetime datetime
);

--データ例
insert into practice.person
(
   name,
   age,
   gender,
   tel,
   mail,
   insert_user,
   insert_datetime
)
values
(
   'user',
   20,
   0,
   '090-0000-0000',
   'test@a.a',
   'insusr',
   sysdate ()
);