package com.roulette.roulette.websocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;

/*@Controller
@RequiredArgsConstructor
@Slf4j

public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/{roomid}")
    @SendTo("/topic/{roomid}")
    public String sendmsg(String msg, @DestinationVariable(value="roomid")String roomid){

        log.info("rommid:{}",roomid);
        return msg;
    }


    @MessageMapping("/offer/{roomid}/{key}")
    @SendTo("/topic/offer/{roomid}/{key}")
    public String offer(String offer,@DestinationVariable(value="roomid")String roomid,@DestinationVariable(value="key") String key){
        log.info("roomid:{} and key:{}",roomid,key);


        return offer;
    }


    @MessageMapping("/answer/{roomid}/{key}")
    @SendTo("/topic/answer/{roomid}/{key}")
    public String answer(String answer,@DestinationVariable(value="roomid")String roomid,@DestinationVariable(value="key") String key){
        log.info("roomid:{} and key:{}",roomid,key);


        return answer;
    }


    @MessageMapping("/candidate/{roomid}/{key}")
    @SendTo("/topic/candidate/{roomid}/{key}")
    public String candidate(String candidate,@DestinationVariable(value="roomid")String roomid,@DestinationVariable(value="key") String key){
        log.info("roomid:{} and key:{}",roomid,key);


        return candidate;
    }


    @MessageMapping("/call/key")
    @SendTo("/topic/call/key")
    public String callKey(@Payload String message) {
        log.info("[Key] : {}", message);
        return message;
    }

    //자신의 camKey 를 모든 연결된 세션에 보내는 webSocket
    @MessageMapping("/send/key")
    @SendTo("/topic/send/key")
    public String sendKey(@Payload String message) {
        return message;
    }






}*/
