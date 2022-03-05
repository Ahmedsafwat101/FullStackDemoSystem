CREATE TABLE employee (
    emp_id  bigint auto_increment primary key,
    created_at datetime not null,
    updated_at datetime not null,
    emp_name varchar(255) not null,
    emp_phone_number varchar(255) not null,
    emp_email varchar(255) not null,
    emp_image_url varchar(255) ,
    emp_title varchar(255) not null,
    emp_code varchar(255) not null
);