package onboarding;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

class Problem1 {

    private static final int PAGE_START = 1;
    private static final int PAGE_END = 399;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return getResult(pobi, crong);
    }

    private static int makeRandomPage() {
        return Randoms.pickNumberInRange(PAGE_START, PAGE_END);
    }

    private static int checkLeftSide(List<Integer> pororo) {
        if (pageSum(pororo.get(0)) > pageMultiplication(pororo.get(0))) {
            return pageSum(pororo.get(0));
        }
        return pageMultiplication(pororo.get(0));
    }

    private static int checkRightSide(List<Integer> pororo) {
        if (pageSum(pororo.get(1)) > pageMultiplication(pororo.get(1))) {
            return pageSum(pororo.get(1));
        }
        return pageMultiplication(pororo.get(1));
    }

    private static int pageSum(int page) {
        if (page < 10) {
            return page;
        }
        String onePage = String.valueOf(page);
        if (page < 100) {
            return Character.getNumericValue(onePage.charAt(0)) + Character.getNumericValue(onePage.charAt(1));
        }
        return Character.getNumericValue(onePage.charAt(0)) + Character.getNumericValue(onePage.charAt(1))
                + Character.getNumericValue(onePage.charAt(2));
    }

    private static int pageMultiplication(int page) {
        if (page < 10) {
            return page;
        }
        String onePage = String.valueOf(page);
        if (page < 100) {
            return Character.getNumericValue(onePage.charAt(0)) * Character.getNumericValue(onePage.charAt(1));
        }
        return Character.getNumericValue(onePage.charAt(0)) * Character.getNumericValue(onePage.charAt(1))
                * Character.getNumericValue(onePage.charAt(2));
    }


    private static int checkWinner(List<Integer> pororo) {
        if (checkLeftSide(pororo) > checkRightSide(pororo)) {
            return checkLeftSide(pororo);
        }
        return checkRightSide(pororo);
    }

    private static int getResult(List<Integer> pobi, List<Integer> crong) {
        if (checkError(pobi) == false || checkError(crong) == false) {
            return -1;
        }
        if (checkWinner(pobi) > checkWinner(crong)) {
            return 1;
        }
        if (checkWinner(pobi) < checkWinner(crong)) {
            return 2;
        }
        if (checkWinner(pobi) == checkWinner(crong)) {
            return 0;
        }
        return -3;
    }

    private static boolean checkError(List<Integer> pororo) {
        if (pororo.get(1) - pororo.get(0) != 1) {
            return false;
        }
        return true;
    }
}