package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Message;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.mapper.MessageMapper;
import com.pam.party_affairs_manegement.mapper.UserMapper;
import com.pam.party_affairs_manegement.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Message> selectNotice(Integer sendObject) {
        return this.messageMapper.selectNotice(sendObject);
    }

    @Override
    public List<Message> selectDocument(Integer sendObject) {
        return this.messageMapper.selectDocument(sendObject);
    }

    @Override
    public List<Message> selectTask(Integer sendObject) {
        return this.messageMapper.selectTask(sendObject);
    }

    @Override
    public List<Message> selectMessage(Integer sendObject) {
        return this.messageMapper.selectMessage(sendObject);
    }

    @Override
    public List<Message> selectByWarning() {
        List<Message> messageList = this.messageMapper.selectByWarning();
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectWarningByTitle(String title, Integer sendObject) {
        List<Message> messageList = this.messageMapper.selectWarningByTitle(title,sendObject);
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectByNews() {
        List<Message> messageList = this.messageMapper.selectByNews();
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectNewsByTitle(String title, Integer sendObject) {
        List<Message> messageList = this.messageMapper.selectNewsByTitle(title,sendObject);
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectByCertificate() {
        List<Message> messageList =  this.messageMapper.selectByCertificate();
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectCertificateByTitle(String title, Integer sendObject) {
        List<Message> messageList = this.messageMapper.selectCertificateByTitle(title,sendObject);
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectByLetter() {
        List<Message> messageList =  this.messageMapper.selectByLetter();
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectLetterByTitle(String title, Integer sendObject) {
        List<Message> messageList = this.messageMapper.selectLetterByTitle(title,sendObject);
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectByHistory() {
        List<Message> messageList = this.messageMapper.selectByHistory();
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public List<Message> selectHistoryByTitle(String title, Integer sendObject) {
        List<Message> messageList = this.messageMapper.selectHistoryByTitle(title,sendObject);
        for (Message message:messageList) {
            Users user = this.userMapper.selectById(message.getSendObject());
            message.setUser(user);
        }
        return messageList;
    }

    @Override
    public int insert(Message message) {
        return this.messageMapper.insert(message);
    }

    @Override
    public Message selectByName(String title, String type) {
        return this.messageMapper.selectByName(title,type);
    }

    @Override
    public List<Message> selectAll() {
        return this.messageMapper.selectAll();
    }

    @Override
    public Message selectById(Integer messageId) {
        return this.messageMapper.selectById(messageId);
    }

    @Override
    public int update(Message message) {
        return this.messageMapper.update(message);
    }

    @Override
    public int delete(Integer messageId) {
        return this.messageMapper.delete(messageId);
    }
}
