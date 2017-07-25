/**
 * 
 */
package com.ceeety.admin.module.common.ui;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月12日
 */
public abstract class ModuleServlet extends HttpServlet {
    
    protected static final Logger LOG = LoggerFactory.getLogger(ModuleServlet.class);

    private static final long serialVersionUID = 2488625853209088353L;
    
    protected Gson gson;
    protected String alias;
    protected StringWriter writer;
    protected VelocityContext context;
    protected LayoutService layoutService;
    
    protected VelocityContext customContext;
    protected StringWriter customWriter;
    protected Template customTemplate;
    
    @Override
    public void init() throws ServletException {
        super.init();
        Properties properties = new Properties();
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        Velocity.init(properties);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("Servlet service(HttpServletRequest req, HttpServletResponse resp)方法....");
        gson = new Gson();
        writer = new StringWriter();
        context = new VelocityContext();
        customWriter = new StringWriter();
        customContext = new VelocityContext();
        String method = request.getMethod();

        if(method.equals("GET")) {
            String uri = alias.endsWith("/") ? alias.substring(0, alias.length()-1) : alias.endsWith("/*") ? alias.substring(0, alias.length()-2) : alias;
            if(isAjaxRequest(request) && request.getRequestURI().equals(uri)){
                doAjaxData(request, response);
                return;
            }else if(request.getRequestURI().equals(uri)){
                doIndex(request, response);
            }else if(request.getRequestURI().startsWith(uri + "/add")){
                doAdd(request, response);
                return;
            }else if(request.getRequestURI().startsWith(uri + "/edit")){
                doEdit(request, response, request.getRequestURI().substring(uri.length()+6));
                return;
            }else if(request.getRequestURI().startsWith(uri + "/delete")){
                doDelete(request, response, request.getRequestURI().substring(uri.length()+8));
                return;
            }else{
                super.service(request, response);
            }
        }else if(method.equals("POST")){
            String _method = request.getParameter("_method");
            if("put".equalsIgnoreCase(_method)){
                doPut(request, response);
                return;
            }else if("delete".equalsIgnoreCase(_method)){
                doDelete(request, response);
                return;
            }else{
                super.service(request, response);
            }
        }else{
            super.service(request, response);
        }
    }
    
    /**
     * 首页(列表页)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    /**
     * Ajax加载数据(列表页)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void doAjaxData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    /**
     * 添加页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    /**
     * 编辑页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void doEdit(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException;
    
    /**
     * 删除对象
     * @param request
     * @param response
     * @param id
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void doDelete(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException;
    
    protected boolean isAjaxRequest(HttpServletRequest request){  
        String header = request.getHeader("X-Requested-With");  
        boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;  
        return isAjax;  
    }
    
    public ModuleServlet(final String alias) {
        this.alias = alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public void setLayoutService(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

}
