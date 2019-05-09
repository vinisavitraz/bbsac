/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ScriptDDL;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Vinicius
 */
@WebServlet(name="StartUpServlet", urlPatterns={"/StartUpServlet"}, loadOnStartup=1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config){
        ScriptDDL.execute();
    }
}