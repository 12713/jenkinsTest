package freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tingxiu.zhou@hand-china.com
 * @version 1.0
 * @name FreeMarkerController
 * @description
 * @date 2017/12/20 15:13
 */
@Controller
public class FreeMarkerController {
	@RequestMapping(value="/index.html",method={RequestMethod.GET})
	public ModelAndView Add(HttpServletRequest request, HttpServletResponse response){
		List<Monitor> monitors = new ArrayList<Monitor>();
		Monitor m1 = new Monitor();
		m1.setFrontEndSystemCode("BG12783321_EBS4.0");
		m1.setStatus(true);
		Monitor m2 = new Monitor();
		m2.setFrontEndSystemCode("BG0006091_EBS_VII");
		m2.setStatus(false);
		monitors.add(m1);
		monitors.add(m2);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("monitors",monitors);
		return mv;
	}
}
