package test.ch07.socket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

    //클라이언트 연결을 받는 소켓
    ServerSocket serverSocket;

    //실제 통신을 하는 소켓
    Socket socket;
    BufferedReader br;

    //새로운 쓰레드가 필요함
    BufferedWriter bw;
    BufferedReader keyboard;

    public ServerFile() {
        System.out.println("1. 서버 소켓 시작-------");
        try{

            serverSocket = new ServerSocket(10000);

            System.out.println("2. 서버소켓 생성 완료: 클라이언트 접속 대기중-----------");
            socket = serverSocket.accept(); //클라이언트 접속 대기중...
            System.out.println("3. 클라이언트 연결 완료 - buffer연결완료(read)");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //write 쓰레드 실행
            WriteTread wt = new WriteTread();
            Thread t1 = new Thread(wt);
            t1.start();

            //main 쓰레드 역할
            while(true){
                String msg = br.readLine();
                System.out.println("4. 클라이언트로 부터 받은 메세지: " + msg);
            }

        }catch (Exception e){
            System.out.println("서버소켓 에러 방생: " + e.getMessage());
        }
    }
    //내부 클래스
    class WriteTread implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    String keyboardMsg = keyboard.readLine();
                    bw.write(keyboardMsg + "\n");
                    bw.flush();
                    System.out.println("키보드 입력 대기중---------");
                } catch (Exception e) {
                    System.out.println("서버쪽에서 키보드 입력받는 중 오류가 발생했습니다 : " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new ServerFile();
    }
}
