package test.ch07;

class 총 {
    void shoot(){
        System.out.println("총을 발사");
    }
        }

public class ExceptionEx01 {

    public static void main(String[] args) {
        try {
            System.out.println("잠자기 시작");
            Thread.sleep(1000); // 메인스레드 1초동안 잠을 잠
            System.out.println("잠자기 끝");
        } catch (Exception e) { //방해
            e.printStackTrace();
        }

        int[] nums = {1,2,3};

        try {
            System.out.println(nums[3]);
        }catch (RuntimeException e){
            System.out.println("괜찮아 그냥 진행해");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        총 s = null;

        try {
            s.shoot();
        }catch (RuntimeException e) {
            System.out.println("총이 없어서 발사하지 못했습니다.");
            s = new 총();
            s.shoot();
        }

        System.out.println("메인스레드 종료");
    }

}
