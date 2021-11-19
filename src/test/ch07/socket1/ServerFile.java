package test.ch07.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

    //클라이언트 연결을 받는 소켓
    ServerSocket serverSocket;

    //실제 통신을 하는 소켓
    Socket socket;
    BufferedReader br;

    public ServerFile() {
        System.out.println("1. 서버 소켓 시작-------");
        try{

            serverSocket = new ServerSocket(10000);
            System.out.println("2. 서버소켓 생성 완료: 클라이언트 접속 대기중-----------");
            socket = serverSocket.accept(); //클라이언트 접속 대기중...
            System.out.println("3. 클라이언트 연결 완료 - buffer연결완료(read)");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String msg = br.readLine();
            System.out.println("4. 클라이언트로 부터 받은 메세지: " + msg);

        }catch (Exception e){
            System.out.println("서버소켓 에러 방생: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ServerFile();
    }
}
