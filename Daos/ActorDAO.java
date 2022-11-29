package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActorDAO {

    static String     driverClassName = "org.postgresql.Driver" ;
    static String     url = "jdbc:postgresql://dblabs.it.teithe.gr:5432/it185280" ;
    static Connection dbConnection = null;
    static String     username = "it185280";
    static String     passwd = "Joykos18/";
    static Statement  statement = null;
    static ResultSet rs = null;


    public static boolean  insertActor(int a_id, String actor_Name, String gender, int age, String movie_title) throws SQLException, ClassNotFoundException {
        movie selectedMovie = findMovie(movie_title);
        actor newActor = new Actor();
        newActor.setMovie_title(selectedMovie.getNameProperty().get());      
        boolean returnState = false;
        System.out.println(selectedMovie);
        if(selectedMovie != null){
            String query = "select * from insert_actor('"+
                    selectedMovie.getIdProperty().get()+"','"+
            Class.forName(driverClassName);
            dbConnection = DriverManager.getConnection(url,username,passwd);
            try {
                statement = dbConnection.createStatement();
                rs = statement.executeQuery(query);
                returnState = true;
            }catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return returnState;
        }else return false;

    }

    public static boolean deleteActor( actor selectedItem) throws SQLException, ClassNotFoundException, ParseException {
        movie selectedMovie  = findMovie(selectedItem.movie_titleProperty().get()) ;
        boolean returnState = false;
    
        if(selectedMovie != null){
    
            String query = "select * from delete_actor('"+
                    selectedMovie.getm_idProperty().get()+"','"+
            Class.forName(driverClassName);
            dbConnection = DriverManager.getConnection(url,username,passwd);
            try {
                statement = dbConnection.createStatement();
                rs = statement.executeQuery(query);
                returnState = true;
            }catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return returnState;
    
        }else return false;
    }


    
        public static Movie findMovie(String movie_title) throws ClassNotFoundException, SQLException {
            Class.forName(driverClassName);
            dbConnection = DriverManager.getConnection(url,username,passwd);
            try{
                Movie mo = new Movie();
                statement = dbConnection.createStatement();
                rs = statement.executeQuery("select * from findMovie('"+movie_title+"')");
                ResultSetMetaData rsMetadata = rs.getMetaData();
                System.out.println(rsMetadata.getColumnCount());
                while (rs.next()) {
                    mo.setm_id(rs.getInt(1));
                    mo.setmovie_title(rs.getString(2));
                    mo.setparagogi(rs.getString(3));
                    mo.setreleaseDate(rs.getInt(4));
                    mo.setcritue(rs.getString(5));
                }
                return ow;
            }catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
}