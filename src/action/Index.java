package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

import bean.SqlBuilder;




@Controller

public class Index {
	@Autowired
	public SqlSessionFactory sqlSessionFactory;

	@SuppressWarnings("finally")
	@RequestMapping(value = "/show")
	public String index(WebRequest webRequest,HttpServletRequest request, HttpServletResponse response) {
	
		try {
			SqlBuilder sb=new SqlBuilder();
			System.out.println("----------");
		
			if(null!=request.getParameter("name")){
				sb.setWhere(request.getParameter("name"));
			}else{
				sb.setWhere("");
			}
		
			List<Map> mapList = sqlSessionFactory.openSession().selectList("showAllSc",sb);

		
			
			request.setAttribute("mapList", mapList);
	
			
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}finally {
			return "index";
		}

	}
	
	
	
	@RequestMapping(value = "/showList")
	public void index1(WebRequest webRequest,HttpServletRequest request, HttpServletResponse response) {
	
		if(null!=request.getHeader("if-Modified-Since")&&webRequest.checkNotModified(getResourceLastModified())){			
			return;
		}else{
			SqlBuilder sb=new SqlBuilder();
			System.out.println("----------");
		
			if(null!=request.getParameter("name")){
				sb.setWhere(request.getParameter("name"));
			}else{
				sb.setWhere("");
			}
			
		
			
			
			List<Map> mapList = sqlSessionFactory.openSession().selectList("showAllSc",sb);
			Gson g=new Gson();
			String rs= g.toJson(mapList);
	/*		System.out.println(rs);*/
			PrintWriter os = null;
			try {
				os = response.getWriter();
				os.println(rs);
				os.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{

				os.close();
			}
			
		};
		
		}	

	

	 private static long getResourceLastModified() {
	       
	        Calendar c = Calendar.getInstance();  
	        c.setTime(new Date());   //设置时间
	        /*c.add(Calendar.YEAR, -3);*/ //日期分钟加1,Calendar.DATE(天),Calendar.HOUR(小时)  
	        Date date = c.getTime(); //结果  
	        return date.getTime();
	    }

	
		
		
		

		
		
	
	
}
