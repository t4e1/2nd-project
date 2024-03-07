package com.teamphoenix.ahub.query.service;

import com.teamphoenix.ahub.query.dto.MemberDTO;
import com.teamphoenix.ahub.query.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class MemberService {
    private MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberDTO> selectAllMembers(){
        List<MemberDTO> members = memberMapper.selectAllMembers();
        System.out.println("전체 회원 목록");
        members.forEach(System.out::println);

        return members;
    }

    public MemberDTO selectByMemberCode(String inputMemberCode){
        int intMemberCode = Integer.valueOf(inputMemberCode);

        Map<String, Integer> memberCode = new HashMap<>();
        memberCode.put("memberCode", intMemberCode);

        MemberDTO member = memberMapper.selectByMemberCode(memberCode);

        return member;
    }

    public MemberDTO selectByMemberId(String inputMemberId){
        Map<String, String> memberId = new HashMap<>();
        memberId.put("memberId", inputMemberId);

        MemberDTO member = memberMapper.selectByMemberId(memberId);

        return member;
    }

    public int getMemberCode(String currentMemberId){
        int memberCode = 0;


        return memberCode;
    }

    public MemberDTO selectMyprofile(String currentMemberId){

        Map<String, String> memberId = new HashMap<>();
        memberId.put("memberId", currentMemberId);

        MemberDTO member = memberMapper.selectMyprofile(memberId);

        return member;
    }

    /* 설명. @requestBody 방식으로 가져온 data */
    public MemberDTO memberLogin(MemberDTO memberLoginInfo){
        String memberId = memberLoginInfo.getMemberId();
        String memberPwd = memberLoginInfo.getMemberPwd();

        Map<String, String> memberLogin = new HashMap<>();
        memberLogin.put("memberId", memberId);
        memberLogin.put("memberPwd", memberPwd);

        MemberDTO member = memberMapper.memberLogin(memberLogin);

        return member;
    }
}