package com.firstmeet.FirstMeet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firstmeet.FirstMeet.model.MeetingScheduling;

public interface MeetingRepository extends JpaRepository<MeetingScheduling, Integer> {
	
	@Query("SELECT m FROM MeetingScheduling m JOIN m.invitees i WHERE i.employee.employeeId = :employeeId AND m.endTime < CURRENT_TIMESTAMP ORDER BY m.meetingDate DESC, m.startTime DESC")
	List<MeetingScheduling> findPastMeetingsByInvitee(@Param("employeeId") int employeeId);

	@Query("SELECT m FROM MeetingScheduling m JOIN m.invitees i WHERE i.employee.employeeId = :employeeId AND m.endTime > CURRENT_TIMESTAMP")
	List<MeetingScheduling> findUpcomingMeetingsByInvitee(@Param("employeeId") int employeeId);

}

