package com.example.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServletContextListenerDemo implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        this.setProperties(servletContext);
        this.setDataSource(servletContext);
        System.out.println("[ Servlet Context Initialized ]");
    }

    private void setProperties(ServletContext servletContext) {
        Properties properties = new Properties();
        String applicationPropertiesRelativePath = servletContext.getInitParameter("applicationPropertiesFilePath");
        System.out.println(String.format("application.properties relative path : %s", applicationPropertiesRelativePath));
        String applicationPropertiesAbsolutePath = servletContext.getRealPath(applicationPropertiesRelativePath);
        System.out.println(String.format("application.properties absolute path : %s", applicationPropertiesAbsolutePath));
        try(FileInputStream fis = new FileInputStream(applicationPropertiesAbsolutePath)) {
            properties.load(fis);
            System.out.println("application.properties file loaded successfully");
            servletContext.setAttribute("properties", properties);
        } catch (FileNotFoundException e) {
            System.out.println("Properties file is not present");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setDataSource(ServletContext servletContext) {
        DataSource dataSource = null;
        Properties properties = (Properties) servletContext.getAttribute("properties");
        if(properties==null || properties.isEmpty()) return;
        String jdbcUrl = properties.getProperty("jdbc.connection.url");
        String username = properties.getProperty("jdbc.connection.username");
        String password = properties.getProperty("jdbc.connection.password");
        System.out.println(String.format("[ JDBC URL : %s | USERNAME : %s | PASSWORD : %s ]", jdbcUrl, username, password));
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        dataSource = new HikariDataSource(config);
        System.out.println("DataSource created successfully");
        servletContext.setAttribute("dataSource", dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[ Servlet Context Destroyed ]");
    }
}

