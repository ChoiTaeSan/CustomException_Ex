import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.printf("성적 %d 입력:",i);
            try {
                int score = scanner.nextInt();
                if (score < 0 || score > 100) { // 성적이 0보다 작거나 100보다 큰 경우 사용자 정의 예외처리
                    throw new CustomException();
                } else {
                    sum += score; // 성적 합계
                }
            } catch (InputMismatchException e) { // 정수가 아닌 값을 입력했을 때의 예외처리
                System.out.println("성적 입력 오류!! 숫자로 다시 입력하세요");
                scanner.next(); // 잘못된 입력을 버리기 위해 사용
                i--; // 반복을 다시 실행하기 위해 i를 감소
            }catch (CustomException e){ // 정수 0~100 사이가 아닌 값을 입력했을 때의 예외처리
                System.out.println("성적 입력 오류!! 0~100사이의 값으로 다시 입력하세요");
                i--; // 반복을 다시 실행하기 위해 i를 감소
            }
        }

        System.out.println("성적 평균은 " +  (double) sum / 5 + "입니다."); // 성적 합계를 형변환 하여 성적 평균 출력

        scanner.close(); // 리소스 누수 방지

    }
}
