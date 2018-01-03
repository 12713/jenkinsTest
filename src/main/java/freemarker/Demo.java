package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tingxiu.zhou@hand-china.com
 * @version 1.0
 * @name Demo
 * @description
 * @date 2017/12/20 11:06
 */
/*public class Demo {*/
	/*public static void main(String[] args) throws Exception{
		List<Monitor> monitors = new ArrayList<Monitor>();
		Monitor m1 = new Monitor();
		m1.setFrontEndSystemCode("BG12783321_EBS4.0");
		m1.setStatus(true);
		Monitor m2 = new Monitor();
		m2.setFrontEndSystemCode("BG0006091_EBS_VII");
		m2.setStatus(false);
		monitors.add(m1);
		monitors.add(m2);
		Map<String,Object> map = new HashMap();
		map.put("monitors",monitors);

		try {
			Configuration  cfg = new Configuration();
			cfg.setDefaultEncoding("UTF-8");
			cfg.setDirectoryForTemplateLoading(new File("D:\\rocket\\demo\\src\\main\\webapp\\WEB-INF\\templates"));
			//创建一个模版对象
			//Template t = new Template(null, new StringReader("前置机名字：${frontEndSystemCode};状态：${status}"), null);
			Template t = cfg.getTemplate("test.ftl");
			//创建插值的Map
			t.process(map,new FileWriter("D:\\freemarkerTest.html"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}*/
//}
