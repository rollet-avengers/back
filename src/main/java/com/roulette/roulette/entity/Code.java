package com.roulette.roulette.entity;

import com.roulette.roulette.type.CodeType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "code")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Code {
    @Id@GeneratedValue
    @Column(name = "code_id")
    private Long codeId;

    @Column(name = "code_url")
    private String codeUrl;

    @Column(name = "code_type")
    private CodeType codeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    private Reply reply;

    @Builder
    public Code(String codeUrl, CodeType codeType, Reply reply) {
        this.codeUrl = codeUrl;
        this.codeType = codeType;
        this.reply = reply;
    }
}
