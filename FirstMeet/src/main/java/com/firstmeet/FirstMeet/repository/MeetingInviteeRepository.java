package com.firstmeet.FirstMeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.firstmeet.FirstMeet.model.MeetingInvitee;

public interface MeetingInviteeRepository extends JpaRepository<MeetingInvitee, Long>{
	
	Optional<MeetingInvitee> findByMeeting_MeetingIdAndEmployee_EmployeeId(int meetingId, int employeeId);
}
