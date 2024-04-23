package com.roulette.roulette.reply.service;

import com.roulette.roulette.code.service.CodeService;
import com.roulette.roulette.entity.Code;
import com.roulette.roulette.entity.Member;
import com.roulette.roulette.entity.Post;
import com.roulette.roulette.entity.Reply;
import com.roulette.roulette.post.repository.PostRepository;
import com.roulette.roulette.reply.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    private final CodeService codeService;
    @Override
    public void setReply(Long postId, String html, String css, String js, Member member) {
        Post post = postRepository.findById(postId).get();

        Reply reply =  Reply.builder()
                .post(post)
                .member(member)
                .build();

        codeService.insertCode(html, css, js, reply);
        replyRepository.save(reply);
    }

    @Override
    public String[] selectReplyById(Long id) {
        Reply reply = replyRepository.findById(id).get();
        String filePath = "upload/code";

        String[] str = new String[3];

        int index = 0;

        for(Code code: reply.getCodes()){
            File file = new File(filePath,code.getCodeUrl());
            BufferedReader br;

            try{
                FileReader reader = new FileReader(file);
                br = new BufferedReader(reader);
                String line = "";
                while ((line = br.readLine()) != null){
                    str[index] += line;
                }
            } catch (IOException e) {
                System.err.println("Unable to read the file: " + e.getMessage());
                return null;  // 또는 적절한 예외 처리
            }
            log.info("실행");
            index++;

        }

        return str;
    }
}
