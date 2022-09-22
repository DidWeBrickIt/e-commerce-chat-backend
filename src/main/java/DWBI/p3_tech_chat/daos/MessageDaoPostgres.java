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
    public int createMessageTable(String username) {
        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "create table " + username + " (message_id int primary key, username varchar not null, message varchar not null)";
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
    public int postMessage(String username, Message message) {
        try( Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into " + username + " values (?, ?, ?)";

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
    public List<Message> getMessagesByUsername(String username) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from " + username;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            List<Message> messageList = new ArrayList<Message>();

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
    public void deleteMessagesByUsername(String username) {
        System.out.println(username);
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "drop table " + username;
            System.out.println(sql);

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
