package gdu.diary.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public class DiaryService {
	
	// 달력구현							
	
	public Map<String, Object> getDiary(String targetYear, String targetMonth) { // null값나오면 에러발생하기에 String
		// 타겟 년,월,일(날짜)
		// 이번달의 1일
		// 이번달의 마지막일의 숫자 -> endDay
		
		// startBlank + endDay + endBlank + (7 - (startBlank + endDay) % 7)
		// 전체 셀의 갯수(마지막일의 숫자보다는 크고 7로 나누어 떨어져야 한다.)
		// 앞의 빈셀의 갯수 -> startBlank
		// 이번달 숫자가 나와야 할 셀의 갯수(1~마지막날짜)
		// 뒤의 빈셀의 갯수 -> endBlank = (startBlank + endDay) % 7
		// 초기화
		Map<String, Object> map = new HashMap<>();
		Calendar target = Calendar.getInstance();
		
		// 년도,월 자동변환
		if(targetYear != null) {
			target.set(Calendar.YEAR, Integer.parseInt(targetYear));
		}
		// ex) 2021년 13월 -> 2022년 1월 자동변환
		if(targetMonth != null) {
			// 두번째 인수값이 -1 이면 target의 년을 -1하고 월은 11(12월)값이 들어간다
			// 두번쨰 인수값이 12 이면 target의 년을 +1하고 월은 0(1월)값이 들어간다
			target.set(Calendar.MONTH, Integer.parseInt(targetMonth));
		}
		/*
		int numTargetMonth = 0;
		int numTargetYear = 0;
		// 년도바꾸기
		if(targetYear != null && targetMonth != null) {
			numTargetYear = Integer.parseInt(targetYear);
			numTargetMonth = Integer.parseInt(targetMonth);
			
			if(numTargetMonth == 0) {
				numTargetYear = numTargetYear - 1;
				numTargetMonth = 12;
				
			} else if(numTargetMonth == 13) {
				numTargetYear = numTargetYear + 1;
				numTargetMonth = 1;
			}
			target.set(Calendar.YEAR, numTargetYear);
			target.set(Calendar.MONTH, numTargetMonth-1);
		}
		*/
		target.set(Calendar.DATE, 1);
		
		//  taget '월'의 1숫자 앞에 와야할 빈셀의 갯수
		int startBlank = target.get(Calendar.DAY_OF_WEEK) - 1;
		// taget `월`의 마지막 날짜
		int endDay = target.getActualMaximum(Calendar.DATE);
		
		int endBlank = 0;
		if((startBlank + endDay)%7 != 0) {
			endBlank = 7 - (startBlank + endDay)%7;
		}
		
		// int totalCell = startBlank + endDay + endBlank;
		
		map.put("targetYear", target.get(Calendar.YEAR));
		map.put("targetMonth", target.get(Calendar.MONTH));
		map.put("startBlank", startBlank);
		map.put("endBlank", endBlank);
		map.put("endDay", endDay);
		
		return map;
	}
}
