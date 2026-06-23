package service.impl;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import entity.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public Member login(String username, String password) {
        return memberDao.login(username, password);
    }

    @Override
    public void createMember(Member member) {
        memberDao.createMember(member);
    }

    @Override
    public boolean checkUsername(String username) {
        return memberDao.checkUsername(username);
    }
}