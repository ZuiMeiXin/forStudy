package com.hisoft.news.dao.impl;

import com.hisoft.news.dao.BaseDao;
import com.hisoft.news.dao.CommentsDao;
import com.hisoft.news.entity.Comment;
import com.hisoft.news.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CommentsDaoImpl extends BaseDao implements CommentsDao {
    public CommentsDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Comment> getCommentsByNid(int nid) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from comments where cnid=? order by cdate desc");
        preparedStatement.setInt(1, nid);
        ResultSet resultSet = preparedStatement.executeQuery();
        Comment comment = null;
        List<Comment> commentList = new ArrayList<>();
        while (resultSet.next()) {
            comment = new Comment();
            comment.setCauthor(resultSet.getString("cauthor"));
            comment.setCip(resultSet.getString("cip"));
            comment.setCdate(resultSet.getTimestamp("cdate"));
            comment.setCcontent(resultSet.getString("ccontent"));
            commentList.add(comment);
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return commentList;
    }

    @Override
    public int addComment(Comment comment) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into comments(cnid,ccontent,cdate,cip,cauthor) value(?,?,?,?,?)");
        preparedStatement.setInt(1, comment.getCnid());
        preparedStatement.setString(2, comment.getCcontent());
        preparedStatement.setObject(3, comment.getCdate());
        preparedStatement.setString(4, comment.getCip());
        preparedStatement.setString(5, comment.getCauthor());
        int update = preparedStatement.executeUpdate();
        ResultSet rs = null;
        JdbcUtil.closeAll(null, preparedStatement, rs);
        return update;
    }

    @Override
    public int deleteCommentByNid(int Nid) throws SQLException {
        int update = 0;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("delete from comments where cnid=?");
        preparedStatement.setInt(1, Nid);
        update = preparedStatement.executeUpdate();
        JdbcUtil.closeAll(null, preparedStatement, null);
        return update;
    }
}
