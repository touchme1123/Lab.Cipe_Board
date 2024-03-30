package com.mySpring.myapp.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mySpring.myapp.board.vo.ArticleVO;


public interface BoardDAO {
	public List selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	//public void insertNewImage(Map articleMap) throws DataAccessException;
	
	public ArticleVO selectArticle(int articleNO) throws DataAccessException;
	public void updateArticle(Map articleMap) throws DataAccessException;
	public void deleteArticle(int articleNO) throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;

	// 3.20 ������ �߰�
	public void modifyRecipe(Map articleMap) throws DataAccessException;
	// 3.20 ������ �߰�
	// 3.19 ������ �߰�
	public void removeRecipe(int recipe_id) throws DataAccessException;
	// 3.19 ������ �߰�
	// 3/20 �ο��� �߰�//
	public List selectSearchArticlesList(String searchWord) throws DataAccessException;
	//3.21 승환
	public int viewcnt(int recipe_id) throws DataAccessException;
	
	public List mostView() throws DataAccessException;
	
	

}
