package test.test1.test2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/move", method = RequestMethod.GET)
	public String move(Locale locale, Model model) {
			
		return "move";
	/*
	 * URL http://localhost:8081/helloWeb/move
	 * http 프로토콜
	 * localhost 도메인주소
	 * 8081 접속포트
	 * helloWeb 사용할 서비스
	 * move 를 포함한 이후 내용 URI
	 *  
	 * */
}
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
			
		return "/form/loginForm";
	
}
	@RequestMapping(value = "loginProc", method = RequestMethod.GET)
	public String loginProc(HttpServletRequest request) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			
			logger.info(id +" :" + pw);
			
		return "home";
	
}
	@RequestMapping(value = "loginanno", method = RequestMethod.GET)
	public String loginanno() {
			
			
		return "/form/loginFormanno";
}
	@RequestMapping(value = "loginProcanno", method = RequestMethod.GET)
	public String loginProc(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw ) {
			
			
			logger.info(id +" :" + pw);
			
		return "home";
	
}	
}
