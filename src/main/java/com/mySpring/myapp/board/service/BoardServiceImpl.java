package com.mySpring.myapp.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mySpring.myapp.board.dao.BoardDAO;
import com.mySpring.myapp.board.vo.ArticleVO;
import com.mySpring.myapp.board.vo.ImageVO;


@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl  implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	
	public List<ArticleVO> listArticles() throws Exception{
		List<ArticleVO> articlesList =  boardDAO.selectAllArticlesList();
        return articlesList;
	}

	
	//�⑥�� �대�몄� 異�媛���湲�
	@Override
	public int addNewArticle(Map articleMap) throws Exception{
		return boardDAO.insertNewArticle(articleMap);
	}
	
	
	  //�⑥�� ���� 蹂댁�닿린
	@Override
	public ArticleVO viewArticle(int articleNO) throws Exception {
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		return articleVO;
	}
	
	
	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.updateArticle(articleMap);
	}
	
	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}
	
	// 3.20 박현수 추가

	@Override
	public void modifyRecipe(Map articleMap) throws Exception {
		boardDAO.modifyRecipe(articleMap);
	}
	// 3.20 박현수 추가
	
	// 3.19 박현수 추가
	@Override
	public void removeRecipe(int recipe_id) throws Exception {
		boardDAO.removeRecipe(recipe_id);
	}
	// 3.19 박현수 추가
	// 새로 추가함 3/20 민영님 //
	@Override
	public List<ArticleVO> searchArticles(String searchWord) throws Exception {
		List<ArticleVO> searchList =  boardDAO.selectSearchArticlesList(searchWord);
        return searchList;
	}
	
	//3.21 승환
	
	public int viewcnt(int recipe_id) {
		return boardDAO.viewcnt(recipe_id);
	}
	
	@Override
	public List<ArticleVO> mostView() throws Exception{
		List<ArticleVO> mostView =  boardDAO.mostView();
        return mostView;
	}
}
