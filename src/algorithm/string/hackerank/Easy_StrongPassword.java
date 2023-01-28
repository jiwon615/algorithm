package algorithm.string.hackerank;

import java.io.*;

/**
 * intput: 랜덤문자열
 *
 * 강한 비밀번호가 되기 위해 필요한 최소 필요한 character 개수
 * (강력한 비번 조건: 최소 6자, digit 1 이상, 대문자 1 이상, 소문자 1 이상, 특별기호 1 이상(!@#$%^&*()_+)
 */
public class Easy_StrongPassword {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int originalPwCnt = Integer.parseInt(br.readLine());
        String originalPw = br.readLine();

        // 출력 하기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = minimumNumber(originalPwCnt, originalPw);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int minimumNumber(int n, String password) {
        int minLength = 6;
        String specialCharacters = "!@#$%^&*()-+";

        int passwordLength = password.length(); // 문자열 길이 (최소 6되야함)
        boolean hasDigit = false; // 숫자 1개 여부
        boolean hasUpperCase = false; // 대문자 여부
        boolean hasLowerCase = false; // 소문자 여부
        boolean hasSpecialChar = false; // 특별기호 여부

        char[] pwCharArr = password.toCharArray();
        for (int i=0; i<pwCharArr.length; i++) {
            if (Character.isUpperCase(pwCharArr[i])) {
                hasUpperCase = true;
            }

            if (Character.isLowerCase(pwCharArr[i])) {
                hasLowerCase = true;
            }

            if (Character.isDigit(pwCharArr[i])) {
                hasDigit = true;
            }

            if (specialCharacters.contains(String.valueOf(pwCharArr[i]))) {
                hasSpecialChar = true;
            }
        }

        int minimumCnt = 0;
        if (!hasUpperCase) minimumCnt++;
        if (!hasLowerCase) minimumCnt++;
        if (!hasDigit) minimumCnt++;
        if (!hasSpecialChar) minimumCnt++;

        int newPwCnt = passwordLength + minimumCnt;
        if (newPwCnt >= minLength) return minimumCnt;
        return minimumCnt + (minLength - newPwCnt);
    }
}