package com.ssafy.Entity.Rooms;

import com.ssafy.Entity.Sprints.Sprint;
import com.ssafy.Entity.Sprints.SprintRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SprintRepository sprintRepository;

    @Test
    public void di(){
        Room room = new Room();
        room.setRoomFlag(true);
        room.setCompleteFlag(false);
        room.setSummary("{}");
        room.setUserCount(10);
        Room rooms = roomRepository.save(room);


        Sprint sprint = new Sprint();
        sprint.setSprintStartDate(new Date());
        sprint.setSprintEndDate(new Date());
        sprint.setSprintGoal("나의 목표는 B형");
        sprint.setSprintCompleteFlag(false);
        sprint.setRoom(rooms);
        Sprint newSprint = sprintRepository.save(sprint);


        newSprint.setSprintStartDate(new Date());
        newSprint.setSprintEndDate(new Date());
        newSprint.setSprintGoal("나의 목표는 A형");
        newSprint.setSprintCompleteFlag(false);
        newSprint.setRoom(rooms);
        sprintRepository.save(sprint);

        sprint = new Sprint();
        sprint.setSprintStartDate(new Date());
        sprint.setSprintEndDate(new Date());
        sprint.setSprintGoal("나의 목표는 B형");
        sprint.setSprintCompleteFlag(false);
        sprint.setRoom(rooms);
        sprintRepository.save(sprint);


//        Sprint sprint1 = new Sprint();
//        sprint1.setRoom(rooms);
//        sprint1.setSprintStartDate(new Date());
//        sprint1.setSprintEndDate(new Date());
//        sprint1.setSprintGoal("나의 목표는 A+형");
//        sprint1.setSprintCompleteFlag(false);
//        Sprint newSprint1 = sprintRepository.save(sprint1);
//        rooms.addSprint(newSprint1);

        System.out.println(room.getSprints().size());

    }
}