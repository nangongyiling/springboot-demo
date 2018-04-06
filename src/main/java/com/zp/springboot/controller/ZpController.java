package com.zp.springboot.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.zp.springboot.bean.Account;
import com.zp.springboot.bean.ConsultContent;
import com.zp.springboot.bean.ConsultContract;
import com.zp.springboot.dao.AccountDao;
import com.zp.springboot.service.CommonService;

@Controller
public class ZpController {

	
	private static final Logger logger = LoggerFactory.getLogger(ZpController.class);
	
	//取配置文件中的值，不存在取默认值
	@Value("${application.hello:Hello zp}")
	private String hello="";
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
    AccountDao accountDao;
	
	@RequestMapping("/page")
	public ModelAndView page(){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("time",new Date());
		model.addObject("message", this.hello);
		return model;
	}
	
	//页面模板freemarker
	@RequestMapping("/freemarker")
	public String freemarker(Map<String,Object> map){
		map.put("name", "dj------我的最爱");
		map.put("gender",0);//gender:性别 ：1：男  0：女
		List<Map<String,Object>> friends = new ArrayList<Map<String,Object>>();
		Map<String,Object> friend = new HashMap<String,Object>();
		friend.put("name", "zp");
		friend.put("age", 18);
		friends.add(friend);
		friend = new HashMap<String,Object>();
		friend.put("name", "dj");
		friend.put("age", 16);
		friends.add(friend);
		map.put("friends",friends);
		return "freemarker";
	}
	
	@RequestMapping("/queryContent")
	public @ResponseBody List<ConsultContent> queryContent(){
		logger.info("查询开始");
		List<ConsultContent> consults = commonService.queryContent(new HashMap());
		logger.info("查询结束");
		return consults;
	}
	
	@RequestMapping("/queryConsultContract")
	public @ResponseBody List<ConsultContract> queryConsultContract(){
		logger.info("查询开始");
		List<ConsultContract> consults = commonService.queryConsultContract();
		logger.info("查询结束");
		return consults;
	}
	
	@RequestMapping("/updateConsultContract")
	public @ResponseBody int updateConsultContract(){
		logger.info("修改开始");
		int count = commonService.updateConsultContract("jpa test",98);
		logger.info("修改结束");
		return count;
	}
	
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public @ResponseBody List<Account> getAccounts() {
        return accountDao.findAll();
    }
    
    @RequestMapping(value={"/","/index"})
    public String index(Map<String,Object> model){
    	//
    	//
    	model.put("time",new Date());
    	model.put("message", this.hello);
    	return "index";
    }
    
    /**
     * 文件上传
     */
    @RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public void uploadFile(HttpServletRequest req,MultipartHttpServletRequest multiReq){
    	//获取上传文件的路径
    	String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
    	logger.info("uploadFilePath:"+uploadFilePath);
    	// 截取上传的文件名
    	String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf("//")+1,
    			uploadFilePath.indexOf("."));
    	logger.info("uploadFileName:"+uploadFileName);
    	
    	//截取上传文件的后缀
    	String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.lastIndexOf(".")+1,
    			uploadFilePath.length());
    	logger.info("uploadFileSuffix:"+uploadFileSuffix);
    	
    	FileOutputStream fos =null;
    	FileInputStream fis = null;
    	try {
			fis = (FileInputStream)multiReq.getFile("file1").getInputStream();
			fos = new FileOutputStream(new File("D:"+File.separator
					+"picture"+File.separator+uploadFileName+"."
					+uploadFileSuffix));
			byte[] temp = new byte[1024];
			int i = fis.read(temp);
			while(i!=-1){
				fos.write(temp,0,temp.length);
				fos.flush();
				i=fis.read(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fis !=null){
				try {
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(fos !=null){
				try {
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
    }
    
    @RequestMapping(value="uploadFiles",method=RequestMethod.POST)
    @ResponseBody
    public void uploadFiles(HttpServletRequest req){
    	List<MultipartFile> list = ((MultipartHttpServletRequest)req).getFiles("file");
    	BufferedOutputStream stream=null;
    	for(MultipartFile file:list){
    		if(!file.isEmpty()){
    			try{
    				//获取上传文件的路径
        	    	String uploadFilePath = file.getOriginalFilename();
        	    	logger.info("uploadFilePath:"+uploadFilePath);
        	    	// 截取上传的文件名
        	    	String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf("//")+1,
        	    			uploadFilePath.indexOf("."));
        	    	logger.info("uploadFileName:"+uploadFileName);
        	    	
        	    	//截取上传文件的后缀
        	    	String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.lastIndexOf(".")+1,
        	    			uploadFilePath.length());
        	    	logger.info("uploadFileSuffix:"+uploadFileSuffix);
        	    	byte[] bytes=file.getBytes();
        	    	stream = new BufferedOutputStream(new FileOutputStream(
        	    			new File("D:"+File.separator+"picture"+File.separator
        	    					+uploadFileName+"."+uploadFileSuffix)));
        	    	stream.write(bytes,0,bytes.length);
    			}catch(Exception e){
    				e.printStackTrace();
    			}finally{
    				if(stream !=null){
    					try {
    						stream.close();
    					} catch (Exception e2) {
    						e2.printStackTrace();
    					}
    				}
    			}
    		}
    	}
    }
    
    @RequestMapping(value="/download",method=RequestMethod.GET)
    public void download(HttpServletResponse res){
		String fileName="info.log";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename="+fileName);
		byte[] buff=new byte[1024];
		BufferedInputStream bis=null;
		OutputStream os=null;
		try{
			os=res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(
					new File("D:"+File.separator+"picture"+File.separator+fileName)));
			int i=bis.read(buff);
			while(i!=-1){
				os.write(buff,0,buff.length);
				os.flush();
				i=bis.read(buff);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bis!=null){
				try {
					bis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
