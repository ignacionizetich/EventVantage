create table users (
                       id varchar(36) primary key not null,
                       name varchar(255) not null,
                       last_name varchar(255) not null,
                       dni varchar(12) unique not null,
                       email varchar(22) unique not null,
                       password varchar(255) not null,
                       phoneNumber varchar(14),
                       enabled boolean default FALSE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP
);