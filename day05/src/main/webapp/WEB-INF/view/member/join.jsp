<%@ page contentType="text/html; charset=utf-8" %>
<form method="post">
    <dl>
        <dt>아이디</dt>
        <dd>
            <input type="text" name="userId" value="${join.userId}">
        </dd>
    </dl>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <input type="password" name="userPw">
        </dd>
    </dl>
    <dl>
        <dt>비밀번호 확인</dt>
        <dd>
            <input type="password" name="userPwRe">
        </dd>
    </dl>
    <dl>
        <dt>회원명</dt>
        <dd>
            <input type="text" name="userNm">
        </dd>
    </dl>
    <div>
        <input type="checkbox" name="agree" value="true" id="agree">
        <label for="agree">회원 가입 약관에 동의합니다.</label>

    </div>
    <button type="submit">가입하기</button>
</form>