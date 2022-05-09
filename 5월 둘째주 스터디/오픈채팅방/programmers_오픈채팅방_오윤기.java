import java.util.*;

class programmers_오픈채팅방_오윤기 {
    static HashMap<String,String> userMap;
    static ArrayList<String> msgList;

    public static void main(String[] args) {
        String[] res = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }
    public static String[] solution(String[] record) {
        userMap = new HashMap<>();
        msgList = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] res = record[i].split(" ");
            String command = res[0];
            String id = res[1];
            String nickName = "";
            if("Enter".equals(command)){
                nickName = res[2];
                userMap.put(id,nickName);
                msgList.add(id+",님이 들어왔습니다.");
            }else if("Leave".equals(command)){
                msgList.add(id+",님이 나갔습니다.");
            }else{
                nickName = res[2];
                userMap.put(id,nickName);
            }
        }
        String[] answer = new String[msgList.size()];
        for(int i = 0 ; i<msgList.size(); i++){
            String[] tmp = msgList.get(i).split(",");
            String id = tmp[0];
            String nickName = userMap.get(id);
            answer[i] = nickName+tmp[1];
        }

        return answer;
    }
}
