package algorithm.study.level1;

public class SecretMap {
     /*
     https://school.programmers.co.kr/learn/courses/30/lessons/17681
    네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
    그런데 이 비밀지도는 숫자로 암호화되어 있어
    위치를 확인하기 위해서는 암호를 해독해야 한다.
    다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

    지도는 한 변의 길이가 n인 정사각형 배열 형태로,
    각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
    전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
    각각 "지도 1"과 "지도 2"라고 하자.
    지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
    지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
    "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
    암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1,
    공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
     */

    public int binaryOr(int a, int b) {
        if (!(a == 0 || a == 1)) {
            return -1;
        }
        if (!(b == 0 || b == 1)) {
            return -1;
        }
        if (a == 1 || b == 1){
            return 1;
        }else {
            return 0;
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        int size = arr1.length;
        char[] matchBin = {' ', '#'};
        String[] resultArr = new String[n];

        for (int i = 0; i < size; i++) {
            StringBuffer sb = new StringBuffer();
            int elem1 = arr1[i];
            int elem2 = arr2[i];
            char[] chars = new char[size];
            int k = 0;
            while (true) {
                int value = binaryOr(elem1 % 2, elem2 %2);
                char s = matchBin[value];
                chars[size - 1 - k] = s;
                elem1 /= 2;
                elem2 /= 2;
                k++;
                if (k == n) {
                    break;
                }
            }
            resultArr[i] = new StringBuffer().append(chars).toString();
        }
        //2진으로 변환 -> 합 -> 문자열 배열로 변환

        return resultArr;
    }
}
