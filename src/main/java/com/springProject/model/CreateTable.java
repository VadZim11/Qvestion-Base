package com.springProject.model;

import com.springProject.controller.AppController;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private static final Logger log = Logger.getLogger(CreateTable.class);
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String createTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS distributors;");
            jdbcTemplate.execute("CREATE TABLE distributors (\n" +
                                 "    id     integer,\n" +
                                 "    name    varchar(40),\n" +
                                 "    PRIMARY KEY(id)\n" +
                                 ");");
            log.info("table successfully created");
            return "DB created";
        } catch (Exception e) {
            log.error(e);
            return e.toString();
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
     }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
     }
}
