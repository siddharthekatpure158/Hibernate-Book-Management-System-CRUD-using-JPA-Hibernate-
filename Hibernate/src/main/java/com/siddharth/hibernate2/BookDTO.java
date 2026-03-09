package com.siddharth.hibernate2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	
	@Id
	@Column(name="id")
	private int bookid;
	@Column(name="bookname")
	private String name;
	private String Author;
	private double price;
	

}
