package com.faitmain.domain.customer.domain;

import java.sql.Date;
import java.util.List;

import com.faitmain.domain.user.domain.User;
import com.faitmain.global.common.Image;

import lombok.Data;

@Data
public class Customer{
	
	private int boardNumber;
	private String boardTitle;
	private String boardContent;
//	private List<Image> boardImage;
	private Date BoardRegDate;
	private Date BoardUpdateDate;
	private int FAQCategoryCode;
	private char boardType;
	private User customerId;
//	private int totalCount;
	private int viewCount;
	private String delete_yn;
	private String Image;




	
	
}
