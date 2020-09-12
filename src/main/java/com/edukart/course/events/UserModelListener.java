package com.edukart.course.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.edukart.course.entity.UserDetailsDto;
import com.edukart.course.service.SequenceGeneratorService;

@Component
public class UserModelListener extends AbstractMongoEventListener<UserDetailsDto> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<UserDetailsDto> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(UserDetailsDto.SEQUENCE_NAME));
        }
    }


}