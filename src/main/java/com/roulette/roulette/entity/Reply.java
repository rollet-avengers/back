package com.roulette.roulette.entity;

import com.roulette.roulette.auditing.Period;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reply")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
public class Reply extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reply",cascade = CascadeType.REMOVE)
    private List<Code> codes;

    public void add(Code code){
        this.codes.add(code);
        code.setReply(this);
    }

}
