package com.mySpring.myapp.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FileDownloadController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\shpark\\article_image";
	@RequestMapping("/download.do")
	protected void download(@RequestParam("file_path") String file_path,
							@RequestParam("recipe_id") String recipe_id,
			                 HttpServletResponse response)throws Exception {
		OutputStream out = response.getOutputStream();
		
		String downFile = ARTICLE_IMAGE_REPO + "\\" +recipe_id+"\\"+ file_path;
		File file = new File(downFile);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + file_path);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer); 
			if (count == -1) 
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

}
