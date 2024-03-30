package com.mySpring.myapp.board.service;

import java.util.List;
import java.util.Map;

import com.mySpring.myapp.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public ArticleVO viewArticle(int articleNO) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
	
	// 3.20 ������ �߰�
	public void modifyRecipe(Map articleMap) throws Exception;
	// 3.20 ������ �߰�
	// 3.19 ������ �߰�
	public void removeRecipe(int recipe_id) throws Exception;
	// 3.19 ������ �߰�
	// 3/20 �ο��� //
	public List<ArticleVO> searchArticles(String searchWord) throws Exception;
	
	//3.21 승환
	public int viewcnt(int recipe_id) throws Exception;
	
	public List<ArticleVO> mostView() throws Exception;
	
	

	
}
