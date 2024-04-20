package com.roulette.roulette.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "code_url")
    private String codeUrl;

    @Column(name = "confirm")
    private boolean confirm;

    @Builder
    public Code(Long codeId, Member member, String codeUrl, boolean confirm) {
        this.codeId = codeId;
        this.member = member;
        this.codeUrl = codeUrl;
        this.confirm = confirm;
    }

}
