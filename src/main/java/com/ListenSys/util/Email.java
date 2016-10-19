package com.ListenSys.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class Email{
    private final String user="1214098151@qq.com";
    private final String pass="pziiyjbfaxnkhebj";//QQ邮箱使用授权码，需要去邮箱的设置里面找

    //收件人、邮件标题、邮件内容
    private String mailTo;
    private String mailTitle;
    private String mailMessage; 

    //所有可设置字段的getter、setter
    public String getMailTo() {
        return mailTo;
    }
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }
    public String getMailTitle() {
        return mailTitle;
    }
    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }
    public String getMailMessage() {
        return mailMessage;
    }
    public void setMailMessage(String mailMessage) {
        this.mailMessage = mailMessage;
    }

    //三个构造函数
    public Email(String mailTo,String mailTitle,String mailMessage){
        this.mailTo=mailTo;
        this.mailTitle=mailTitle;
        this.mailMessage=mailMessage;
    }
    public Email(String mailTo){
        this.mailTo=mailTo;
    }
    public Email(){}
    //验证是否邮件状态正确
    public boolean checkMail(){
        if(mailTo!=null&&mailTitle!=null&&mailMessage!=null) return true;
        return false;
    }

    public void SendMail() throws GeneralSecurityException, MessagingException{
        //邮件状态不正确，取消发送
        if(!checkMail()){
            System.out.println("mail state wrong");
            return ;
        }
        Properties prop = new Properties();
        //开启ssl验证
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //输出debug信息
        //prop.setProperty("mail.debug", "true");
        //服务器
        prop.setProperty("mail.host", "smtp.qq.com");
        //prop.setProperty("mail.smtp.port", "25");
        //传输方式
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        // 创建session
        Session session = Session.getInstance(prop);
        Transport ts = null;
        // 通过session得到transport对象
        ts = session.getTransport();
        // 连上邮件服务器
        ts.connect(user,pass);
        MimeMessage message = new MimeMessage(session);
        // 邮件消息头
        /* 邮件的发件人，可以不设置成自己的真实邮箱
        对方通过正常手段（邮件客户端、网页）收到邮件，看不到真实的发件人，而只能看到这里设置的发件人
        */
        message.setFrom(new InternetAddress(user)); // 邮件的发件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo)); // 邮件的收件人
        message.setSubject(mailTitle); // 邮件的标题
        // 邮件消息体
        message.setText(mailMessage);
        // 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }


}
