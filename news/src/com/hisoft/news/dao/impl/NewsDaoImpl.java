package com.hisoft.news.dao.impl;

import com.hisoft.news.dao.NewsDao;
import com.hisoft.news.entity.News;
import com.hisoft.news.dao.BaseDao;
import com.hisoft.news.util.JdbcUtil;
import com.hisoft.news.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    public NewsDaoImpl(Connection connection) {
        super(connection);
    }

    /*分页查询 所有新闻*/
    @Override
    public List<News> queryAllNews(int currPageNo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List newslist = new ArrayList();
        Page page = new Page();
        News news = null;
        try {
            ps = connection.prepareStatement("select nid,ntitle,nauthor,ncreateDate from news order by ncreateDate desc limit ?,?");
            ps.setInt(1, (currPageNo - 1) * page.getPageSize());
            ps.setInt(2, page.getPageSize());
            rs = ps.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreateDate(rs.getTimestamp("ncreateDate"));
                newslist.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(null, ps, rs);
        }
        return newslist;
    }

    /*查询所有的新闻*/
    @Override
    public List<News> queryAllNews() {
        List<News> newslist = new ArrayList();
        Page page = new Page();
        News news = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select nid,ntitle,nauthor,ncreateDate from news order by ncreateDate desc ");
            rs = ps.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreateDate(rs.getTimestamp("ncreateDate"));
                newslist.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(null, ps, rs);
        }
        return newslist;
    }

    /*通过主题id查询主题下所有的新闻*/
    @Override
    public List<News> queryNewsByTid(int tid) throws SQLException, ClassNotFoundException {
        List<News> newsList = new ArrayList<>();
        News news = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select nid,ntitle,ncreateDate from news where ntid=? order by ncreateDate desc");
        preparedStatement.setInt(1, tid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            news = new News();
            news.setNid(resultSet.getInt("nid"));
            news.setNtitle(resultSet.getString("ntitle"));
            news.setNcreateDate(resultSet.getTimestamp("ncreateDate"));
            newsList.add(news);
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return newsList;
    }

    /*根据新闻id查询所有的新闻*/
    @Override
    public News queryNewsByNid(int nid) throws SQLException, ClassNotFoundException {
        News news = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from news where nid=? ");
        preparedStatement.setInt(1, nid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            news = new News();
            news.setNid(resultSet.getInt("nid"));//新闻id
            news.setNtitle(resultSet.getString("ntitle"));//标题
            news.setNauthor(resultSet.getString("nauthor"));//作者
            news.setNsummary(resultSet.getString("nsummary"));//摘要
            news.setNcreateDate(resultSet.getTimestamp("ncreateDate"));//时间
            news.setNcontent(resultSet.getString("ncontent"));//新闻内容
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return news;
    }

    /*根据主题名称查询所有的新闻*/
    @Override
    public List<News> queryAllNewsByTopic(String tname) throws SQLException, ClassNotFoundException {
        List<News> newsList = new ArrayList<>();
        News news = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select nid,ntitle,ncreateDate from news,topic where ntid=tid and  tname=?  limit 5 ");
        preparedStatement.setString(1, tname);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            news = new News();
            news.setNid(resultSet.getInt("nid"));
            news.setNtitle(resultSet.getString("ntitle"));
            news.setNcreateDate(resultSet.getTimestamp("ncreateDate"));
            newsList.add(news);
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return newsList;
    }

    /*通过id删除新闻*/
    @Override
    public int deleteNewsByNid(int nid) throws SQLException {
        int update = 0;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("delete from news where nid=?");
        preparedStatement.setInt(1, nid);
        update = preparedStatement.executeUpdate();
        JdbcUtil.closeAll(null, preparedStatement, null);
        return update;
    }

    /*通过主题id查询新闻总数*/
    @Override
    public int queryAllnewsCount(Integer tid) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (tid == null) {
            preparedStatement = connection.prepareStatement("select count(1) from news");
        } else {
            preparedStatement = connection.prepareStatement("select count(1) from news where ntid=?");
            preparedStatement.setInt(1, tid);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int newscount = resultSet.getInt(1);
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return newscount;
    }

    /*分页查询新闻  根据新闻主题id和当前的页号，以及页面大小查询对应的新闻*/
    @Override
    public List<News> queryPageNews(Integer tid, int currPageNo, int pageSize) throws SQLException {
        PreparedStatement preparedStatement = null;
        News news = null;
        List<News> newsList = new ArrayList<>();
        if (tid == null) {
            preparedStatement = connection.prepareStatement("select * from news order by ncreateDate desc limit ?,? ");
            preparedStatement.setInt(1, (currPageNo - 1) * pageSize);
            preparedStatement.setInt(2, pageSize);
        } else {
            preparedStatement = connection.prepareStatement("select * from news where ntid=? order by ncreateDate desc limit ?,? ");
            preparedStatement.setInt(1, tid);
            preparedStatement.setInt(2, (currPageNo - 1) * pageSize);
            preparedStatement.setInt(3, pageSize);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            news = new News();
            news.setNid(resultSet.getInt("nid"));
            news.setNtitle(resultSet.getString("ntitle"));
            news.setNauthor(resultSet.getString("nauthor"));
            news.setNcontent(resultSet.getString("ncontent"));
            news.setNcreateDate(resultSet.getTimestamp("ncreateDate"));
            newsList.add(news);
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return newsList;
    }

    /*添加新闻*/
    @Override
    public int addNews(News news) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into news(ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nsummary) value(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, news.getNtid());
        preparedStatement.setString(2, news.getNtitle());
        preparedStatement.setString(3, news.getNauthor());
        preparedStatement.setObject(4, news.getNcreateDate());
        preparedStatement.setString(5, news.getNpicPath());
        preparedStatement.setString(6, news.getNcontent());
        preparedStatement.setString(7, news.getNsummary());
        int update = preparedStatement.executeUpdate();
        JdbcUtil.closeAll(null, preparedStatement, null);
        return update;
    }


}
