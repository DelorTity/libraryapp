package com.softwify.libraryapp.constants;

public class Queries {
	public static final String GET_AUTHORS = "select * from author order by firstname, lastname";
	public static final String DELETE_AUTHOR = "delete from author where id = ?";
	public static final String ADD_AUTHOR = "insert into author (`firstname`, `lastname`) values (?, ?)";
	public static final String CHECK_IF_AUTHOR_EXIST = "select count(*) from author where firstname = ? and lastname = ?";
	public static final String JPA_GET_AUTHOR_BY_FIRSTNAME_AND_LASTNAME = "select a from Author a where a.firstName = :firstName and a.lastName = :lastName";
	public static final String JPA_GET_TEXTBOOKS = "select t from Textbook t";
	public static final String GET_TEXTBOOKS = "select * from textbook t, author a where t.author_id = a.id order by title";
	public static final String GET_AUTHOR = "select * from author where firstname = ? and lastname = ?";
	public static final String DELETE_TEXTBOOK = "delete from textbook where textbook.id = ?";
	public static final String GET_TEXTBOOK = "select * from textbook t, author a where t.author_id = a.id and t.id = ?";
	public static final String ADD_TEXTBOOK = "insert into textbook (`title`, `author_id`, `isbn`, `editor`, `publication_date`) values (?, ?, ?, ?, ?)";

}
