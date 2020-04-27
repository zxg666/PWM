package com.pam.party_affairs_manegement.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pam.party_affairs_manegement.domain.Message;
import com.pam.party_affairs_manegement.domain.Organization;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.MessageService;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/resources")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    //警示信息管理
    @RequestMapping("warningManagement")
    public String warningManagement(Model model){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectByWarning();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //按标题和发送对象查询警示信息
    @RequestMapping("warningList")
    public String warningList(Model model,String title,Integer sendObject){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectWarningByTitle(title,sendObject);
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    /*//新增消息
    @RequestMapping("add")
    public String add(Organization organization){
        Message message1 = this.messageService.selectById(organization.getOrganizationId());
        if (message1 == null){
            Organization organization2 = new Organization();
            String organizationName = organization.getOrganizationName();
            organization2.setOrganizationName(organizationName);
            String organizationLeader = organization.getOrganizationLeader();
            organization2.setOrganizationLeader(organizationLeader);
            String organizationInfo = organization.getOrganizationInfo();
            organization2.setOrganizationInfo(organizationInfo);
            Integer parentId = organization.getParentId();
            organization2.setParentId(parentId);
            String telephone = organization.getTelephone();
            organization2.setTelephone(telephone);
            organization2.setEntryTime(new Date());
            this.messageService.insert(message2);
            System.out.println(organization2);
            return "redirect:/organization/organizationManagement";
        }else{
            return "basic/organization/add";
        }
    }*/

    /*//修改消息
    @RequestMapping("edit/{organizationId}")
    public String edit(@PathVariable("organizationId") Integer organizationId, Organization organization){
        Organization organization1 = new Organization();
        organization1.setOrganizationId(organizationId);
        String organizationName = organization.getOrganizationName();
        organization1.setOrganizationName(organizationName);
        String organizationLeader = organization.getOrganizationLeader();
        organization1.setOrganizationLeader(organizationLeader);
        String organizationInfo = organization.getOrganizationInfo();
        organization1.setOrganizationInfo(organizationInfo);
        Integer parentId = organization.getParentId();
        organization1.setParentId(parentId);
        String telephone = organization.getTelephone();
        organization1.setTelephone(telephone);
        this.messageService.update(organization1);
        System.out.println("---------"+organization1);
        return "redirect:/organization/organizationManagement";
    }
*/
    //删除消息
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Message message = this.messageService.selectById(id);
        System.out.println("message"+message);
        this.messageService.delete(id);
        return "redirect:/organization/organizationManagement";
    }

    //新闻活动信息管理
    @RequestMapping("newsManagement")
    public String newsManagement(Model model){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectByNews();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //按标题和发送对象查询新闻活动
    @RequestMapping("newsList")
    public String newsList(Model model,String title,Integer sendObject){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectNewsByTitle(title,sendObject);
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //证明信管理
    @RequestMapping("certificateManagement")
    public String certificateManagement(Model model){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectByCertificate();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //按标题和发送对象查询证明信
    @RequestMapping("certificateList")
    public String certificateList(Model model,String title,Integer sendObject){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectCertificateByTitle(title,sendObject);
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //介绍信管理
    @RequestMapping("letterManagement")
    public String letterManagement(Model model){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectByLetter();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //按标题和发送对象查询介绍信
    @RequestMapping("letterList")
    public String letterList(Model model,String title,Integer sendObject){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectLetterByTitle(title,sendObject);
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //历史信息管理
    @RequestMapping("historyManagement")
    public String historyManagement(Model model){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectByHistory();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //按标题和发送对象查询历史信息
    @RequestMapping("historyList")
    public String historyList(Model model,String title,Integer sendObject){
        List<Users> usersList = userService.selectAll();
        model.addAttribute("usersList",usersList);
        List<Message> messageList = this.messageService.selectHistoryByTitle(title,sendObject);
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/message/message_management";
    }

    //展示历史信息
    @RequestMapping("history")
    public String history(Model model){
        List<Message> messageList = this.messageService.selectByHistory();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/history/history";
    }
    //展示证明信
    @RequestMapping("certificate")
    public String certificate(Model model){
        List<Message> messageList = this.messageService.selectByCertificate();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/certificate/certificate";
    }

    //展示介绍信
    @RequestMapping("letter")
    public String letter(Model model){
        List<Message> messageList = this.messageService.selectByLetter();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/letter/letter";
    }

    //展示警示信息
    @RequestMapping("warning")
    public String warning(Model model){
        List<Message> messageList = this.messageService.selectByWarning();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/warning/warning";
    }

    //展示新闻活动
    @RequestMapping("news")
    public String news(Model model){
        List<Message> messageList = this.messageService.selectByNews();
        model.addAttribute("messageList",messageList);
        System.out.println("messageList:"+messageList);
        return "resources/news/news";
    }
}
