package com.example.demo3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TargetSample {
  public static void main(String[] args) throws Exception {
    for (Section section : getAllSections()) {
      System.out.println("***************************");
      System.out.println("section.id : " + section.id);
      System.out.println("section.name : " + section.name);
    }
  }
  public static List<Section> getAllSections() throws Exception {
    Class.forName("org.postgresql.Driver");
    List<Section> returnValues = new ArrayList<Section>();
    try (
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM section");) {

      while (resultSet.next()) {
        Section section = new Section();
        section.id = resultSet.getLong("id");
        section.name = resultSet.getString("name");
        returnValues.add(section);
      }
    }
    return returnValues;
  }
}