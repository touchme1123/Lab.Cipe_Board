package com.mySpring.myapp.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


public interface BoardController {
	
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception;
	
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO,
			                        HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;
	public ResponseEntity  removeArticle(@RequestParam("articleNO") int articleNO,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity modifyRecipe(MultipartHttpServletRequest multipartRequest,  HttpServletResponse response) throws Exception;
	public ResponseEntity  removeRecipe(@RequestParam("recipe_id") int recipe_id,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 3/20 �ο�//
   public ModelAndView searchArticle(@RequestParam("searchWord") String searchWord,
				HttpServletRequest request, HttpServletResponse response) throws Exception;

   // 3.21 승환
   public Map<String, Boolean> viewcnt(@RequestParam("recipe_id") int recipe_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
