# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                            integer auto_increment not null,
  title                         varchar(255),
  price                         integer,
  author                        varchar(255),
  constraint pk_book primary key (id)
);

create table user (
  id                            integer auto_increment not null,
  type                          integer,
  username                      varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists book;

drop table if exists user;

