package com.mySpring.myapp.board.vo;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {
	private int recipe_id;
	private String create_date;
	private String file_path;
	private String member_id;
	private String recipe_category;
	private String recipe_ingredients;
	private String recipe_name;
	private String recipe_text;
	private int viewcnt;
	
	public int getViewcnt() {
		return viewcnt;
	}


	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}


	public ArticleVO() {
		System.out.println("ArticleVO ������ ȣ��");
	}
	

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getRecipe_category() {
		return recipe_category;
	}

	public void setRecipe_category(String recipe_category) {
		this.recipe_category = recipe_category;
	}

	public String getRecipe_ingredients() {
		return recipe_ingredients;
	}

	public void setRecipe_ingredients(String recipe_ingredients) {
		this.recipe_ingredients = recipe_ingredients;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getRecipe_text() {
		return recipe_text;
	}

	public void setRecipe_text(String recipe_text) {
		this.recipe_text = recipe_text;
	}

//	public int getParentNO() {
//		return parentNO;
//	}
//
//	public void setParentNO(int parentNO) {
//		this.parentNO = parentNO;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public Date getWriteDate() {
//		return writeDate;
//	}
//
//	public void setWriteDate(Date writeDate) {
//		this.writeDate = writeDate;
//	}
//
//	public String getImageFileName() {
//		return imageFileName;
//	}
//
//	public void setImageFileName(String imageFileName) {
//		try {
//			if(imageFileName!= null && imageFileName.length()!=0) {
//				this.imageFileName = URLEncoder.encode(imageFileName,"UTF-8");
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
