public class CustomException extends RuntimeException{ // 사용자 정의 예외 클래스
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }
}