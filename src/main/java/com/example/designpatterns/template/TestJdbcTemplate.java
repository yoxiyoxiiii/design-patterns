package com.example.designpatterns.template;

public class TestJdbcTemplate extends JdbcTemplate {
    @Override
    protected String url() {
        return "localhost:///test";
    }

    public static void main(String[] args) {
        TestJdbcTemplate testJdbcTemplate = new TestJdbcTemplate();
        testJdbcTemplate.save();
    }
}
