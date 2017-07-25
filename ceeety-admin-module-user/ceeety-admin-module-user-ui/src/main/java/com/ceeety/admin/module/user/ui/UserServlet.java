/**
 * 
 */
package com.ceeety.admin.module.user.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

import com.ceeety.admin.module.common.ui.ModuleServlet;
import com.ceeety.admin.module.common.ui.Page;
import com.ceeety.admin.module.user.model.User;
import com.ceeety.admin.module.user.service.UserService;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月13日
 */
public class UserServlet extends ModuleServlet {

    private static final long serialVersionUID = 2488625853209088353L;
    
    private UserService userService;
    
    public UserServlet(String alias) {
        super(alias);
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * 用户首页
     * @param req
     * @param resp
     */
    protected void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("doIndex .......");
        //自定义模板渲染
        customTemplate = Velocity.getTemplate("/admin/module/user/index.html");
        customTemplate.merge(customContext, customWriter);
        
        //Layout模板渲染
        Template layoutTemplate = layoutService.getLayoutTemlate();
        context.put("title", "用户列表");
        context.put("body", customWriter.toString());
        layoutTemplate.merge(context, writer);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(writer.toString());
    }
    
    /**
     * 分页请求数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doAjaxData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("AjaxData .......");
        Page<?> page = Page.createDataTablePage(request);
        page.setTotal(userService.countOf());
        page.setData(userService.queryForPage(page.getOffset(), page.getMax()));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(page.dataTableToJson());
    }
    
    /**
     * 添加用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("doAdd .......");
        //自定义模板渲染
        customTemplate = Velocity.getTemplate("/admin/module/user/add.html");
        customTemplate.merge(customContext, customWriter);
        
        //Layout模板渲染
        Template layoutTemplate = layoutService.getLayoutTemlate();
        context.put("title", "添加用户");
        context.put("body", customWriter.toString());
        layoutTemplate.merge(context, writer);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(writer.toString());
    }
    
    @Override
    protected void doEdit(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        LOG.info("doEdit ......");
        //自定义模板渲染
        customTemplate = Velocity.getTemplate("/admin/module/user/edit.html");
        customContext.put("user", userService.queryForId(Integer.parseInt(id)));
        customTemplate.merge(customContext, customWriter);
        
        //Layout模板渲染
        Template layoutTemplate = layoutService.getLayoutTemlate();
        context.put("title", "编辑用户");
        context.put("body", customWriter.toString());
        layoutTemplate.merge(context, writer);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(writer.toString());
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        LOG.info("doDelete ......");
        userService.deleteById(Integer.parseInt(id));
        //重定向
        response.sendRedirect("/admin/module/user");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Post 请求......");
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        userService.create(user);
        resp.sendRedirect("/admin/module/user");
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Put 请求......");
        User user = userService.queryForId(Integer.parseInt(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        userService.update(user);
        resp.sendRedirect("/admin/module/user");
    }
    
}
