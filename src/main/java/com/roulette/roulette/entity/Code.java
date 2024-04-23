package com.roulette.roulette.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "code")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
public class Code {
    @Id@GeneratedValue
    @Column(name = "code_id")
    private Long codeId;

    @Column(name = "html_code_url")
    private String htmlCodeUrl;

    @Column(name = "css_code_url")
    private String cssCodeUrl;

    @Column(name = "js_code_url")
    private String jsCodeUrl;

    @OneToOne(mappedBy = "code")
    private Reply reply;

}
