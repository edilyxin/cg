package com.rc.util;

import java.util.HashMap;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/** *//**
* <b>类</b>： DataBase<br>
* <b>版本</b>： 1.0.0<br>
* <b>作者</b>： wiThouTTears<br>
* <b>时间</b>： 2006-12-18<br>
* <b>QQ</b>： 314765755<br>
* <b>Email</b>： wiThouT--Tears@163.com<br>
* <b>Blog</b>： http://blog.csdn.net/withouttears/<br>
* <b>功能</b>： 用连接池连接MySql数据库及相关操作<br>
* */
public class DataBase {
    /** *//**
     * 数据库JNDI名称，默认：jdbc/testdb
     * */
    private String jndiName="jdbc/testdb";
    /** *//**
     * 建立连接池
     * @param null
     * @return DataSource
     * */
    private DataSource localhost(){
        DataSource ds=null;
        //在HashMap中通过get()来获取value，通过put()来插入value，
        //ContainsKey()则用来检验对象是否已经存在
        HashMap<Object,Object> cachedDs=new HashMap<Object,Object> ();
        if(cachedDs.containsKey("ds"))//取出空闲状态的数据库连接
          {
                /**//* 在DataSource中事先建立了多个数据库连接，
                 * 这些数据库连接保存在连接池(Connect Pool)中。
                 * Java程序访问数据库时，只需要从连接池中取出空闲状态的数据库连接；
                 * 当程序访问数据库结束，再将数据库连接放回连接池。
                 * */
                ds = (DataSource)cachedDs.get("ds");
            }
        else
            try
            {
                    /**//*在javax.naming包中提供了Context接口，
                     * 该接口提供了将对象和名字绑定，以及通过名字检索对象的方法。
                     * */
                Context initCtx = new InitialContext();
                //lookup(String name)：返回与指定的名字绑定的对象,获得数据库连接工厂
                ds = (DataSource)initCtx.lookup("java:comp/env/"+getjndiName());
                cachedDs.put("ds", ds);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                return ds;
        }
    /** *//**
     * 库的连接
     * @param null
     * @return Connection
     * */
    public Connection getConnection(){
        Connection conn = null;
        try{
            DataSource ds = localhost();
            conn = ds.getConnection();
            }
        catch(Exception e){
            e.printStackTrace();
            }
        return conn;
        }
    /** *//**
     * 关闭连接
     * @param conn
     * @return null
     * @since 1.2
     * */
    public static void close(Connection conn){
        try{
            if(conn != null)
                conn.close();
            }
        catch(SQLException e){
            e.printStackTrace();
            }
        }
    /** *//**
     * 执行查询操作
     * @param sql
     * @return ResultSet
     * */
    public ResultSet executeQuery(String sql)
    { 
        Connection conn=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            }
        catch(Exception e) {
            System.out.println(e.toString()); 
            }
        finally{
            try{
                conn.close(); 
                }
            catch(Exception ex){}
            }
        return rs;
        }
    /** *//**
     * 执行数据的插入、删除、修改操作
     * @param sql
     * @return boolean
     * */
    public boolean executeUpdate(String sql){
        boolean bl;
        bl = false;
        Connection conn = getConnection();
        try{
            Statement stmt = conn.createStatement();
            if(stmt.executeUpdate(sql) > 0)
                stmt.close();
            bl = true;
            }
        catch(SQLException e){}
        finally{
            close(conn);
            }
        return bl;
        }
    /** *//**
     * 获得数据库JNDI名称
     * @param null
     * @return String
     * */
    public String getjndiName(){
        return this.jndiName;
    }
    /** *//**
     * 设置数据库JNDI名称
     * @param jndiName
     * @return true|false
     * */
    public boolean setjndiName(String jndiName){
        this.jndiName = jndiName;
        return true;
        }
    
    
//    第三步: 编写test.jsp测试
//
//    <%@page import="withouttears.bean.Database"%>
//    <%@page import="java.sql.*"%>
//    <html>
//    <head>
//    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
//    <title>Insert title here</title>
//    </head>
//    <body>
//    <%
//    Database db=new Database();
//    db.setjndiName("jdbc/testdb");//初始化JNDI名称
//
//    ResultSet rs=db.executeQuery("select * from test_table");
//    while(rs.next())...{
//            out.println("id:"+rs.getInt("id")+"<br>");
//    }
//    rs.close();
//    %>
//    </body>
//    </html>
}


