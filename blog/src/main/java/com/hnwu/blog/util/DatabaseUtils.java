package com.hnwu.blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseUtils.class);

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.60.44:3350/rober?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "maxwell.1";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }
    public static Connection getConnection(){
        List<String> tables = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("can not connection", e);
        }

        return conn;
    }

    public static void closeResource(ResultSet rs, PreparedStatement ps, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                LOGGER.error("close resultset failure", e);
            }
        }
        if(ps != null){
            try{
                ps.close();
            } catch (SQLException e){
                LOGGER.error("close PreparedStatement failure",  e);
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }

    public static List<String> getTables(){
        List<String> tables = new ArrayList<String>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            DatabaseMetaData data = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = data.getTables(null, null, null, new String[] { "TABLE" });
            while (rs.next()){
                tables.add(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(rs, null, conn);
        }
        return tables;
    }


    public static   List<TableBean> getColumns(String table){

        String sql = "show full columns from ";
        List<TableBean> columns = new ArrayList<TableBean>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        TableBean tableBean = null;
        try {
            ps = conn.prepareStatement("select * from " + table);
            rs = ps.executeQuery(sql + table);
            while(rs.next()){
                tableBean = new TableBean();
                tableBean.setCode(rs.getString(1));
                tableBean.setName(rs.getString(9));
                tableBean.setType(rs.getString(2));
                columns.add(tableBean);
            }

        } catch (SQLException e) {
            LOGGER.error("getColumnNames failure", e);
        } finally {
            closeResource(rs, ps, conn);
        }
        return columns;
    }

    public static void main(String[] args) throws IOException {
        List<TableBean> beans = getColumns("ITPO_BASE");
        createJavaBean(beans);
    }


    public static void createJavaBean(List<TableBean> tableBeans) throws IOException {
        File file = new File("D:\\Test1.java");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        tableBeans.stream().forEach(bean -> {
            String code = "";
            String dataType = "";
            String name = "//" + bean.getName();
            String type = bean.getType().toUpperCase();
            if(type.contains("CHAR")){
                dataType = "String";
            }else if(type.contains("DATE")){
                dataType = "Date";
            }else if(type.contains("INT")){
                dataType = "int";
            }else if(type.contains("NUM")){
                dataType = "double";
            }else {
                dataType = "String";
            }
            code = bean.getCode().toLowerCase();
            while(code.indexOf("_") > -1){
                String pre = code.substring(code.indexOf("_") ,code.indexOf("_") +2);
                String after = pre.toUpperCase().replace("_","");
                code = code.replace(pre, after);
            }
            code = "private " + dataType + " " + code + ";";
            //打印到控制台
            System.out.println(name);
            System.out.println(code);
            try {
                bw.write(name);
                bw.newLine();
                bw.write(code);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("io exception in", e);
            }
        });
        bw.close();
    }


}
