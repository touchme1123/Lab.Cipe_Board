package com.mySpring.myapp.board.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.myapp.board.service.BoardService;
import com.mySpring.myapp.board.vo.ArticleVO;
import com.mySpring.myapp.member.vo.MemberVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\shpark\\article_image";
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;

	@Override
	@RequestMapping(value = "/board/listArticles.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;

	}

	@RequestMapping(value = { "/", "/main.do" }, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		List mostViewList = boardService.mostView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("mostViewList", mostViewList);
		return mav;
	}

	//chineseFood 카테고리
	@RequestMapping(value = { "/board/chineseFood.do" }, method = RequestMethod.GET)
	private ModelAndView listChinese(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List chineseList = boardService.listArticles();
		System.out.println(viewName);
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if (memberVO == null) {
			session.setAttribute("memberID", "게스트");
		} else {
			session.setAttribute("memberID", memberVO.getId());
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("chineseList", chineseList);
		return mav;
	}
	//japaneseFood 카테고리
	@RequestMapping(value = { "/board/japaneseFood.do" }, method = RequestMethod.GET)
	private ModelAndView listJapanese(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List japaneseList = boardService.listArticles();
		System.out.println(viewName);
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if (memberVO == null) {
			session.setAttribute("memberID", "게스트");
		} else {
			session.setAttribute("memberID", memberVO.getId());
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("japaneseList", japaneseList);
		return mav;
	}
	
	//koreanFood 카테고리
	@RequestMapping(value = { "/board/koreanFood.do" }, method = RequestMethod.GET)
	private ModelAndView listKorean(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List koreanList = boardService.listArticles();
		System.out.println(viewName);
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if (memberVO == null) {
			session.setAttribute("memberID", "게스트");
		} else {
			session.setAttribute("memberID", memberVO.getId());
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("koreanList", koreanList);
		return mav;
	}
	//westernFood 카테고리
	@RequestMapping(value = { "/board/westernFood.do" }, method = RequestMethod.GET)
	private ModelAndView listWestern(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List westernList = boardService.listArticles();
		System.out.println(viewName);
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if (memberVO == null) {
			session.setAttribute("memberID", "게스트");
		} else {
			session.setAttribute("memberID", memberVO.getId());
		}
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("westernList", westernList);
		return mav;
	}
	
	//레시피 조회수
	@Override
	@RequestMapping(value = "/board/viewcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> viewcnt(@RequestParam("recipe_id") int recipe_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Boolean cntResult = boardService.viewcnt(recipe_id) > 0;
		System.out.println("컨트롤러 실행됨");
		Map<String, Boolean> result = new HashMap<>();
		result.put("result", cntResult);
		return result;
	}

	//레시피수정
	@RequestMapping(value = "/board/modifyRecipe.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modifyRecipe(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> recipeMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			recipeMap.put(name, value);
			System.out.println(name + ", " + value);
		}

		String file_path = upload(multipartRequest);
		recipeMap.put("file_path", file_path);
		
		System.out.println("테테테테스트" + file_path);

		String recipe_id = (String) recipeMap.get("recipe_id");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modifyRecipe(recipeMap);
			if (file_path != null && file_path.length() != 0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + file_path);
				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + recipe_id);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);

				String originalFile_path = (String) recipeMap.get("originalFile_path");
				File oldFile_path = new File(ARTICLE_IMAGE_REPO + "\\" + recipe_id + "\\" + originalFile_path);
				oldFile_path.delete();
			}
			message = "<script>";
			message += "alert('글을 수정했습니다.');";
			message += "const before = document.referrer;";
			message += "window.location.href = before;";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + file_path);
			srcFile.delete();
			message = "<script>";
			message += "alert('오류가 발생했습니다.다시 수정해주세요');";
			message += "const before = document.referrer;";
			message += "window.location.href = before;";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	// 레시피삭제
	@Override
	@RequestMapping(value = "/board/removeRecipe.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeRecipe(@RequestParam("recipe_id") int recipe_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		try {
			boardService.removeRecipe(recipe_id);
			File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + recipe_id);
			FileUtils.deleteDirectory(destDir);
			message = "<script>";
			message += " alert('글을 삭제합니다.');";
			message += "const before = document.referrer;";
			message += "window.location.href = before;";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('작업중 오류가 발생했습니다.다시 시도해 주세요.');";
			message += "const before = document.referrer;";
			message += "window.location.href = before;";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}

		return resEnt;
	}
	// 레시피생성
	@Override
	@RequestMapping(value = "/board/addNewArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();

		Enumeration enu = multipartRequest.getParameterNames();
		String category_value = "";
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			System.out.println(name + ", " + value);
			if (name.equals("recipe_category")) {
				category_value = value;
			}
			articleMap.put(name, value);
		}

		String file_path = upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id = memberVO.getId();
		System.out.println("멤버아이디: " + id);
		articleMap.put("member_id", id);
		articleMap.put("file_path", file_path);

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int recipeId = boardService.addNewArticle(articleMap);
			if (file_path != null && file_path.length() != 0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + file_path);
				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + recipeId);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}

			message = "<script>";
			message += " alert('새글을 추가했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/" + category_value + ".do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + file_path);
			srcFile.delete();

			message = " <script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요');');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/" + category_value + ".do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	// 레시피서치
	@Override
	@RequestMapping(value = { "/board/searchArticle.do" }, method = RequestMethod.GET)
	public ModelAndView searchArticle(@RequestParam("searchWord") String searchWord, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(searchWord);
		List searchList = boardService.searchArticles(searchWord);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("searchList", searchList);
		return mav;
	}

	@RequestMapping(value = "/board/viewArticle.do", method = RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		articleVO = boardService.viewArticle(articleNO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);
		return mav;
	}


	// 한 개 이미지 수정 기능
	@RequestMapping(value = "/board/modArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		String imageFileName = upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");

		String id = memberVO.getId();
		articleMap.put("id", id);
		articleMap.put("imageFileName", imageFileName);

		String articleNO = (String) articleMap.get("articleNO");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modArticle(articleMap);
			if (imageFileName != null && imageFileName.length() != 0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);

				String originalFileName = (String) articleMap.get("originalFileName");
				File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + originalFileName);
				oldFile.delete();
			}
			message = "<script>";
			message += " alert('글을 수정했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
			srcFile.delete();
			message = "<script>";
			message += " alert('오류가 발생했습니다.다시 수정해주세요');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/viewArticle.do?articleNO="
					+ articleNO + "';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	@Override
	@RequestMapping(value = "/board/removeArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.removeArticle(articleNO);
			File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
			FileUtils.deleteDirectory(destDir);

			message = "<script>";
			message += " alert('글을 삭제했습니다.');";
			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('작업중 오류가 발생했습니다.다시 시도해 주세요.');";
			message += " location.href='" + request.getContextPath() + "/board/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}

	@RequestMapping(value = "/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	// 한개 이미지 업로드하기
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		String imageFileName = null;
		Iterator<String> fileNames = multipartRequest.getFileNames();

		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName = mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO + "\\" + fileName);
			if (mFile.getSize() != 0) { // File Null Check
				if (!file.exists()) { // 경로상에 파일이 존재하지 않을 경우
					if (file.getParentFile().mkdirs()) { // 경로에 해당하는 디렉토리들을 생성
						file.createNewFile(); // 이후 파일 생성
					}
				}
				mFile.transferTo(new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName)); // 임시로 저장된
																										// multipartFile을
																										// 실제 파일로 전송
			}
		}
		return imageFileName;
	}

}
