package SH;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/

public class OpenChattingRoom {
	public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<String, String>();
        List<String[]> userInfo = new LinkedList<>();
        
        for (String records : record) {
            String[] temp = records.split(" ");
            
            if (temp[0].equals("Enter")) {
                idMap.put(temp[1], temp[2]);
                userInfo.add(temp);
            } else if (temp[0].equals("Change")) {
                idMap.put(temp[1], temp[2]);
            } else {
                userInfo.add(temp);
            }
        }
        
        String[] answer = new String[userInfo.size()];
        int idx = 0;
        
        for (String[] keyWords : userInfo) {
            String nickName = idMap.get(keyWords[1]);
            
            if (keyWords[0].equals("Enter")) {
                answer[idx++] = nickName + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nickName + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
