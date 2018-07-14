package cn.standard.controller;
import cn.standard.dao.StandardMapper;
import cn.standard.pojo.Standard;
import cn.standard.service.StandardMapperService;
import cn.standard.tools.Page;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private StandardMapper standardMapper;
    @Autowired
    private StandardMapperService standardMapperService;

    @RequestMapping(value = "/he")
    public  String test(){
        return "login";
    }


    @RequestMapping(value = "/index")
    @ResponseBody
    public  String index(@RequestParam String name,@RequestParam Integer pageNo,@RequestParam Integer pageSize){
        int totalCount = 0;
        if(name==null||name.equals("")){
            totalCount = standardMapper.selectCount();
        }else {
            totalCount = standardMapper.selectCountName(name);
        }
        List<Standard> list = standardMapperService.findAllInfosByPageByName(name, pageNo, pageSize);
        Page page = new Page();
        page.setList(list);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        return JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd");
    }



    @RequestMapping(value = "/save")
    public  String save(){
        return "add";
    }


    @RequestMapping(value = "/insert")
    public  String insert(@RequestParam("picture") MultipartFile picture,
                          HttpServletRequest request,
                          @RequestParam("gb") String gb,
                          HttpServletResponse response,
                          @RequestParam("zhong") String zhong,
                          @RequestParam("version") String version,
                          @RequestParam("key") String key,
                          @RequestParam("date") String date,
                          @RequestParam("date1") String date1
    ) throws IOException, ParseException {
        String packagepath = null;
        Standard st = new Standard();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(!picture.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/uploads/");
            //上传文件名
            String filename = picture.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            picture.transferTo(new File(path + File.separator + filename));
            packagepath =filename;

            st.setPackagepath(packagepath);
            st.setKe(key);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            st.setReleasedate(simpleDateFormat.parse(date));
            st.setImpldate(simpleDateFormat.parse(date1));
            st.setStdnum(gb);
            st.setVersion(version);
            st.setZhname(zhong);
            standardMapper.insertSelective(st);
        }
        else {
            System.out.println("null==========");
        }
        return "redirect:save";
    }


    @RequestMapping(value = "/gb")
    @ResponseBody
    public  String isSimple(@RequestParam String gb){
        Standard stand = standardMapper.findStandardBystdnum(gb);
        String message=null;
        if(stand==null){
            message = "tru";
        }else {
            message = "fals";
        }
        HashMap<String,String> k=new HashMap<String,String>();
        k.put("aja",message);
        return JSON.toJSONString(k);
    }


    @RequestMapping(value = "/go")
    public ModelAndView gotoupdate(@RequestParam("id") Integer  id){
        Standard st = standardMapper.selectByPrimaryKey(id);
        ModelAndView mv = new  ModelAndView();
        HashMap<String,Object> hs = new HashMap<>();
        hs.put("st",st);
        hs.put("id",id);
        mv.addObject("hs",hs);
        mv.setViewName("update");
        return mv;
    }


    @RequestMapping(value = "/update",produces="text/html;charset=UTF-8")
    public  String update(@RequestParam("picture") MultipartFile picture,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam("zhong") String zhong,
                          @RequestParam("version") String version,
                          @RequestParam("key") String key,
                          @RequestParam("id") Integer id,
                          @RequestParam("date") String date,
                          @RequestParam("date1") String date1
    ) throws IOException, ParseException {
        String packagepath = null;
        PrintWriter out = response.getWriter();
        if(!picture.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/uploads/");
            //上传文件名
            String filename = picture.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            picture.transferTo(new File(path + File.separator + filename));
            packagepath = filename;
            Standard st = new Standard();
            st.setPackagepath(packagepath);
            st.setKe(key);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            st.setReleasedate(simpleDateFormat.parse(date));
            st.setImpldate(simpleDateFormat.parse(date1));
            st.setVersion(version);
            st.setId(id);
            System.out.println(zhong);
            standardMapper.updateByPrimaryKeySelective(st);
        }else {
            System.out.println("请选择上传文件");
        }
        return "index";
    }




    @RequestMapping(value = "/del")
    @ResponseBody
    public  String dels(HttpServletRequest request){
        String items = request.getParameter("delitems");
        String[] strs = items.split(",");
        int a=0;
        for (int i = 0; i < strs.length; i++) {
                int id = Integer.parseInt(strs[i]);
                a=standardMapper.deleteByPrimaryKey(id);
        }
        return JSON.toJSONString(a);
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(@RequestParam("id") Integer id,
                                           HttpServletRequest request
    ){
        Standard st = standardMapper.selectByPrimaryKey(id);
        String path1 = st.getPackagepath();
        String filename=path1;
        ServletContext scontext=request.getServletContext();
        String path = request.getServletContext().getRealPath("/uploads/"+filename);
        System.out.println(path);
        File f=new File(path);
        InputStream in;
        ResponseEntity<byte[]> response=null ;
        try {
            in = new FileInputStream(f);
            byte[] b=new byte[in.available()];
            in.read(b);
            HttpHeaders headers = new HttpHeaders();
            filename = new String(filename.getBytes("gbk"),"iso8859-1");
            headers.add("Content-Disposition", "attachment;filename="+filename);
            HttpStatus statusCode=HttpStatus.OK;
            response = new ResponseEntity<byte[]>(b, headers, statusCode);
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }




}
