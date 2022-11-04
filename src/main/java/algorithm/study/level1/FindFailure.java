package algorithm.study.level1;
import java.util.*;
public class FindFailure {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/42889
    멍한 상태에서 더럽게 풀어서 다시 풀기
     */
    Map<Integer, Stage> map = new HashMap<>();

    class Stage {
        int stageNumber;
        int inTry;
        int totalTry;

        public Stage(int stageNumber) {
            this.stageNumber = stageNumber;
        }

        public void setStageNumber(int stageNumber) {
            this.stageNumber = stageNumber;
        }

        public void setInTry() {
            inTry++;
        }

        public void setTotalTry() {
            this.totalTry++;
        }

        double getFailure() {
            return inTry / (double)totalTry;
        }

        @Override
        public String toString() {
            return "Stage{" +
                    "stageNumber=" + stageNumber +
                    ", inTry=" + inTry +
                    ", totalTry=" + totalTry +
                    ", comparator=" + comparator +
                    '}';
        }

        @Override
        public boolean equals(Object stage) {
            if (stage instanceof Stage) {
                Stage stage1 = (Stage) stage;
                if (stage1.equals(stage1.stageNumber)) {
                    return true;
                }
            }
            return false;
        }

        Comparator<Stage> comparator = new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                double failure1 = o1.getFailure();
                double failure2 = o2.getFailure();
                if (failure1 < failure2) {
                    return 1;
                } else if (failure1 > failure2) {
                    return -1;
                } else {
                    if (o1.stageNumber > o2.stageNumber) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        public Comparator<Stage> getComparator(){
            return this.comparator;
        }


    }

    public int[] solution(int N, int[] stages) {
        for (int i = 1; i <= N+1; i++) {
            map.put(i, new Stage(i));
        }


        for (int i = 0; i < stages.length; i++) {
            int inTry = stages[i];
            for (int j = 1; j < inTry; j++) {
                map.get(j).totalTry++;
            }
            map.get(inTry).totalTry++;
            map.get(inTry).inTry++;
        }

        Stage[] stagesArr = new Stage[N];

        for (Integer integer : map.keySet()) {
            Stage stage = map.get(integer);
            if (stage.stageNumber == N+1){
                continue;
            }
            stagesArr[integer-1] = stage;
        }

        Arrays.sort(stagesArr, stagesArr[0].getComparator());
        int[] resultArr = new int[stagesArr.length];

        for (int i = 0; i < stagesArr.length; i++) {
            Stage stage = stagesArr[i];
            resultArr[i] = stage.stageNumber;
        }

        int[] answer = {};
        return resultArr;
    }

}
