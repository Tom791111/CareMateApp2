package service;

import entity.Member;

public interface MemberService {

    // 登入判斷
    Member login(String username, String password);

    // 註冊 / 新增會員
    void createMember(Member member);

    // 檢查帳號是否重複
    boolean checkUsername(String username);
}