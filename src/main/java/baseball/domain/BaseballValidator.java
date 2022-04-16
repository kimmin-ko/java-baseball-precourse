package baseball.domain;

import java.util.*;

/**
 * 사용자 입력 값 검증기
 *
 * @author : kimmin
 * @since : 2022-04-15 오후 22:31
 */
public final class BaseballValidator {

    private static final int NUMBER_LENGTH = 3;

    private BaseballValidator() {
    }

    /**
     * 사용자가 입력한 세 자리 숫자를 검증한다.
     * @param inputNumber 사용자가 입력한 세 자리 숫자
     */
    public static void validate(String inputNumber) {
        requiredNonNull(inputNumber);
        lengthMustBeThree(inputNumber);
        mustBeNumber(inputNumber);
        requiredNotContainsZero(inputNumber);
        nonDuplication(inputNumber);
    }

    /**
     * 사용자가 0을 입력하면 예외를 발생시킨다.
     * @param inputNumber 사용자가 입력한 숫자
     */
    private static void requiredNotContainsZero(String inputNumber) {
        if (inputNumber.contains("0"))
            throw new IllegalArgumentException("입력 값에 0이 포함될 수 없습니다.");
    }

    /**
     * 게임 종료 후 사용자가 입력한 게임 옵션 값을 검증한다.
     * @param gameOption 사용자가 입력한 게임 옵션 값
     */
    public static void validateGameOption(String gameOption) {
        requiredNonNull(gameOption);
        requiredOneOrTwo(gameOption);
    }

    /**
     * 게임 옵션이 유효하지 않으면 예외를 발생시킨다.
     * @param gameOption 사용자가 입력한 게임 옵션 값
     */
    private static void requiredOneOrTwo(String gameOption) {
        if (isValidGameOption(gameOption))
            throw new IllegalStateException("게임 옵션은 1 또는 2이어야 합니다.");
    }

    /**
     * 게임 옵션이 유효한 값인지 검증한다.
     * @param gameOption 사용자가 입력한 게임 옵션 값
     * @return true: 유효한 값, false: 잘못된 값
     */
    private static boolean isValidGameOption(String gameOption) {
        return !gameOption.equals("1") && !gameOption.equals("2");
    }

    /**
     * 값이 비어있거나 널이면 예외를 발생시킨다.
     * @param str 사용자가 입력한 값
     */
    private static void requiredNonNull(String str) {
        if (isEmptyStr(str))
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
    }

    /**
     * @param inputNumber 사용자가 입력한 값
     * @return true: 비어있거나 널, false: 비어있지 않음
     */
    private static boolean isEmptyStr(String inputNumber) {
        return Objects.isNull(inputNumber) || inputNumber.trim().isEmpty();
    }

    /**
     * 값의 길이가 3이 아니면 예외를 발생시킨다.
     * @param inputNumber 사용자가 입력한 값
     */
    private static void lengthMustBeThree(String inputNumber) {
        if (isNotThree(inputNumber.length()))
            throw new IllegalArgumentException("입력 값의 길이가 3이어야 합니다. : " + inputNumber);
    }

    /**
     * @param length 문자열 길이
     * @return true: 길이가 3이 아님, false: 길이가 3
     */
    private static boolean isNotThree(int length) {
        return length != NUMBER_LENGTH;
    }

    /**
     * 사용자가 입력한 값에 문자가 포함되어있으면 예외를 발생시킨다.
     * @param inputNumber 사용자가 입력한 값
     */
    private static void mustBeNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다. : " + inputNumber, e);
        }
    }

    /**
     * 사용자가 입력한 값이 중복되었으면 예외를 발생시킨다.
     * @param inputNumber 사용자가 입력한 값
     */
    private static void nonDuplication(String inputNumber) {
        List<String> inputNumberList = Arrays.asList(inputNumber.split(""));
        HashSet<String> inputNumberSet = new HashSet<>(inputNumberList);

        if (inputNumberList.size() != inputNumberSet.size())
            throw new IllegalArgumentException("입력 값이 중복 되었습니다. : " + inputNumber);
    }

}