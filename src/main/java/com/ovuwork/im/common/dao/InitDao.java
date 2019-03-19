package com.ovuwork.im.common.dao;

import com.serverlite.dao.D;
import com.serverlite.dao.dialet.MySqlDialet;
import com.serverlite.dao.dialet.OracleDialet;
import com.serverlite.dao.dialet.PostgreSqlDialet;
import com.serverlite.dao.dialet.SqlServer2000Dialet;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class InitDao  {
	
	public void InitServerliteDao(DataSource dataSource,String dialet,boolean showSql){
    	
        if(dataSource == null){
            throw new RuntimeException("init dao failure,dataSource is null.");
        }
        D.setDataSource(dataSource);
        //MySql,Oracle,PostgreSql,SqlServer2000
        if("MySql".equals(dialet)){
            D.setDialet(new MySqlDialet());
        } else if("Oracle".equals(dialet)){
            D.setDialet(new OracleDialet());
        } else if("PostgreSql".equals(dialet)){
            D.setDialet(new PostgreSqlDialet());
        } else if("SqlServer2000".equals(dialet)){
            D.setDialet(new SqlServer2000Dialet());
        } else {
            throw new RuntimeException("dialet not found,use default dialet mysql.");
        }
        D.setShowSql(showSql);
    }
    
}
