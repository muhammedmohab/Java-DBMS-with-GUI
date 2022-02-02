# Java DBMS with GUI

Java application to view records from MySql 

## To test the app

You need to setup the same database as us!

```sql
CREATE TABLE contact (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
nick_name VARCHAR(50),
address VARCHAR(50),
home_phone VARCHAR(50),
work_phone VARCHAR(50),
cell_phone VARCHAR(50),
email VARCHAR(50),
birthdate date , 
web_site VARCHAR(50),
profession VARCHAR(50)
);

INSERT INTO contact (name , nick_name , address , home_phone , work_phone , cell_phone , email , birthdate , web_site , profession)
values ('bruce wayne' , 'batman' , 'XYZ batcave' , '9876543210' , '5646355','454263456', 'batman@gmail.com' , '1976/2/3','batblog','super hero'),
       ('Mohamed hamdy' , 'Canopus' , 'Dar el salam' , '98765432545410' , '5654646355','4454263456', 'Canopus@gmail.com' , '1999/1/5','Starblog','brightestSTAR'),
       ('AHmed Shokry' , 'berserk' , 'bersergstreet' , '98765432120' , '56465355','4544263456', 'shokry@gmail.com' , '1998/12/18','shokyblog','super hero');
```

## Usage
You can run the main file which has the GUI connection with the backend!

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
