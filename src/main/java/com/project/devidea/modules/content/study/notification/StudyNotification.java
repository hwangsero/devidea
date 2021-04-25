package com.project.devidea.modules.content.study.notification;

import com.project.devidea.modules.account.Account;
import com.project.devidea.modules.account.repository.AccountRepository;
import com.project.devidea.modules.content.study.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudyNotification {
    public void sendRelated(Study study,StudyNoticationType type);
    public void sendOwn(Study study, Account account,StudyNoticationType type);
    public void sendAll(Study study,Account account,StudyNoticationType type);
}
