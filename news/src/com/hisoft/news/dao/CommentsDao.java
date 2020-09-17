package com.hisoft.news.dao;

import com.hisoft.news.entity.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentsDao {
    List<Comment> getCommentsByNid(int nid) throws SQLException, ClassNotFoundException;
    int addComment(Comment comment) throws SQLException, ClassNotFoundException;

    /*根据新闻id删除新闻下的评论*/
    int deleteCommentByNid(int Nid) throws SQLException;

}
