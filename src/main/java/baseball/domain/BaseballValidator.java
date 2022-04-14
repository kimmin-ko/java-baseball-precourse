package baseball.domain;

import java.util.*;

public final class BaseballValidator {

    private static final int NUMBER_LENGTH = 3;

    private BaseballValidator() {
    }

    public static void validate(String inputNumber) {
        requiredNonNull(inputNumber);
        lengthMustBeThree(inputNumber);
        mustBeNumber(inputNumber);
        nonDuplication(inputNumber);
    }

    private static void requiredNonNull(String inputNumber) {
        if (isEmptyStr(inputNumber))
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
    }

    private static boolean isEmptyStr(String inputNumber) {
        return Objects.isNull(inputNumber) || inputNumber.trim().isEmpty();
    }

    private static void lengthMustBeThree(String inputNumber) {
        if (isNotThree(inputNumber.length()))
            throw new IllegalArgumentException("입력 값의 길이가 3이어야 합니다. : " + inputNumber);
    }

    private static boolean isNotThree(int length) {
        return length != NUMBER_LENGTH;
    }

    private static void mustBeNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다. : " + inputNumber, e);
        }
    }

    private static void nonDuplication(String inputNumber) {
        List<String> inputNumberList = Arrays.asList(inputNumber.split(""));
        HashSet<String> inputNumberSet = new HashSet<>(inputNumberList);

        if (inputNumberList.size() != inputNumberSet.size())
            throw new IllegalArgumentException("입력 값이 중복 되었습니다. : " + inputNumber);
    }

}
