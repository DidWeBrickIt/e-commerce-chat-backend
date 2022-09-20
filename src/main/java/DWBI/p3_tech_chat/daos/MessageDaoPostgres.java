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

            String sql = "create table ? (message_id int primary key, message varchar not null)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

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
            String sql = "insert into ? values (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, message.getMsgId());
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
    public List<Message> getAllMessages(String username) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            ps.execute();

            List<Message> messageList = new ArrayList<Message>();

            while(rs.next()) {
                Message message = new Message();
                message.setMsgId(rs.getInt("message_id"));
                message.setMessage(rs.getString("message"));
                messageList.add(message);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAllMessages(String username) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "drop table ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.execute();

            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
