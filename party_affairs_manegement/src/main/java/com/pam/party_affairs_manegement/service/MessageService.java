package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Message;

import java.util.List;

public interface MessageService {
    //首页公告
    List<Message> selectNotice(Integer sendObject);
    //首页公文
    List<Message> selectDocument(Integer sendObject);
    //首页个人任务
    List<Message> selectTask(Integer sendObject);
    //首页消息
    List<Message> selectMessage(Integer sendObject);
    //查找警示信息
    List<Message> selectByWarning();
    //按标题或发送人查找警示信息
    List<Message> selectWarningByTitle(String title, Integer sendObject);
    //查找新闻活动信息
    List<Message> selectByNews();
    //按标题或发送人查找新闻活动信息
    List<Message> selectNewsByTitle(String title, Integer sendObject);
    //查找证明信
    List<Message> selectByCertificate();
    //按标题或发送人查找证明信
    List<Message> selectCertificateByTitle(String title, Integer sendObject);
    //查找介绍信
    List<Message> selectByLetter();
    //按标题或发送人查找介绍信
    List<Message> selectLetterByTitle(String title, Integer sendObject);
    //查找历史信息
    List<Message> selectByHistory();
    //按标题或发送人查找历史信息
    List<Message> selectHistoryByTitle(String title, Integer sendObject);
    //添加资源
    int insert(Message message);
    //按标题或内容查找资源
    Message selectByName(String title, String type);
    //查找所有资源
    List<Message> selectAll();
    //根据ID查找资源
    Message selectById(Integer messageId);
    //修改资源信息
    int update(Message message);
    //删除资源
    int delete(Integer messageId);
}
