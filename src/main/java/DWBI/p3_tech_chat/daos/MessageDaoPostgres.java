package DWBI.p3_tech_chat.daos;

import DWBI.p3_tech_chat.entities.Message;
import DWBI.p3_tech_chat.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoPostgres implements MessageDao{

    @Override
    public int createMessageTable(String name) {
        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "create table " + name + " (message_id int primary key, username varchar not null, message varchar not null)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            conn.close();
            return 1;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int postMessage(String name, Message message) {
        try( Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into " + name + " values (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, message.getMsgId());
            ps.setString(2, message.getUsername());
            ps.setString(3, message.getMessage());

            ps.execute();
            conn.close();

            return 1;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Message> getMessagesByUsername(String name) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from " + name;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            List<Message> messageList = new ArrayList<>();


            while(rs.next()) {

                Message message = new Message();
                message.setMsgId(rs.getInt("message_id"));
                message.setUsername(rs.getString("username"));
                message.setMessage(rs.getString("message"));
                messageList.add(message);
            }
            conn.close();
            return messageList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteMessagesByUsername(String name) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "drop table " + name;
            System.out.println(sql);

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();



            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> getAllTables(){
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<String> tables = new ArrayList<>();
            String sql = "SELECT *\n" +
                    "FROM pg_catalog.pg_tables\n" +
                    "WHERE schemaname != 'pg_catalog' AND \n" +
                    "    schemaname != 'information_schema'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                tables.add(rs.getString(2));
            }
            return tables;

        }catch(SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
