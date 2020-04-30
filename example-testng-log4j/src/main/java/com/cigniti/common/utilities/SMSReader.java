package com.cigniti.common.utilities;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageDeleter;

public class SMSReader {

    private static final String ACCOUNT_SID = "AC24673463acc41171a9a7f011d8aeab56";
    private static final String AUTH_TOKEN = "580e00bad1062d81dab31d09c1071274";
    private static final String TO_PHONE_NUMBER = "+15807564136"; //test number where we receive SMS

    public SMSReader(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String getMessage(){
        return getMessages()
                    .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                    .filter(m -> m.getTo().equals(TO_PHONE_NUMBER))
                    .map(Message::getBody)
                    .findFirst()
                    .orElseThrow(IllegalStateException::new);
    }
    //deletes all the messages
    public void deleteMessages(){
        getMessages()
                .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals(TO_PHONE_NUMBER))
                .map(Message::getSid)
                .map(sid -> Message.deleter(ACCOUNT_SID, sid))
                .forEach(MessageDeleter::delete);

    }
    
    private Stream<Message> getMessages(){
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }

}