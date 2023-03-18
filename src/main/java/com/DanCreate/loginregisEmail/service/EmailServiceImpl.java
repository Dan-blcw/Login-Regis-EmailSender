package com.DanCreate.loginregisEmail.service;

import com.DanCreate.loginregisEmail.service.interfaces.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    /*
        sử dụng JavaMailSender nhớ trong POM.xml phải có dependency của javamailsender nha bro
        không là lại lỗi resourse thôi =))
        giải thích sơ lược : g.springframework.mail.javamail là 1 API Spring Framework cung cấp cho ta
        để gửi email, hoặc só thể dùng org.springframework.mail
    */
    //  hoạt động giống như log thường dụng của slf4j, lười giải thích, quên tự xem lại =) hương đần của tương lai
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    /*
        @Async - không đồng bộ : vì method send có thế block ứng dụng
    */
    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("nothing@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new RuntimeException("failed to send email");
        }
    }
}
