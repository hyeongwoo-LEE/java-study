package test.ch07;

public class StringEx01 {

    public static void main(String[] args) {
        String s1 = new String("바다");
        String s2 = new String("바다");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);

        String s3 = "바다";
        String s4 = "바다";
        System.out.println(s3 == s4);

        s3 += "태양";
        System.out.println(s3);

        s3 += "달";
        System.out.println(s3);
        //가비지 컬레션

        //String 풀
        //장점 : 같은 문자열 (같은 메모리 공간 공유) -> 메모리 효율 상승
        //단점 : 문자열을 변경하게 될 때 마다 새로운 공간이 할당 -> 자주 변경지 좋지 x
        // 문자열 비교할 때 -> s1 s2 s3 s4 (바다)
        System.out.println(s1.equals("바다")); //문자열 값 자체와 주소 두개를 비교
    }}
