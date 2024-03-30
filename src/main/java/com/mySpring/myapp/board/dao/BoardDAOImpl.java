package com.mySpring.myapp.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mySpring.myapp.board.vo.ArticleVO;
import com.mySpring.myapp.board.vo.ImageVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}
	

	@Override
	public List mostView() throws DataAccessException {
		List<ArticleVO> mostView = mostView = sqlSession.selectList("mapper.board.mostView");
		return mostView;
	}

	// 새로 추가함 3/20 민영님 //
		@Override
		public List selectSearchArticlesList(String searchWord) throws DataAccessException {
			List<ArticleVO> searchList = searchList = sqlSession.selectList("mapper.board.selectRecipeBySearchWord", searchWord);
			return searchList;
		}
	///////////////////
	// 誘쇱�� ���� //
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int recipeId = selectNewRecipeId();
		articleMap.put("recipe_id", recipeId);
		System.out.println("recipeID : " + recipeId);
		sqlSession.insert("mapper.board.insertArticle",articleMap);
		return recipeId;
	}
	/////////////
	
	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle", articleNO);
		
	}
	
	// 3.20 박현수 추가

	@Override
	public void modifyRecipe(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.modifyRecipe", articleMap);
	}
	// 3.20 박현수 추가
	// 3.19 박현수 추가
	@Override
	public void removeRecipe(int recipe_id)throws DataAccessException {
		sqlSession.delete("mapper.board.removeRecipe", recipe_id); 
	}
	// 3.19 박현수 추가
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.selectImageFileList",articleNO);
		return imageFileList;
	}
	
	// 誘쇱�� ���� //
	private int selectNewRecipeId() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewRecipeId");
	}
	/////////////
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}

	@Override
	public int viewcnt(int recipe_id) throws DataAccessException {
		return sqlSession.update("mapper.board.viewcnt", recipe_id);
		
	}

}
