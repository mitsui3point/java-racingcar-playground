package util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {
    public static final String DEFAULT_REGEX = "[,:]";
    public static final String DEFAULT_TEXT = "0";
    private final String text;

    public AddCalculator(String text) {
        if (isTextEmpty(text)) {
            this.text = DEFAULT_TEXT;
            return;
        }
        this.text = text;
    }

    public Result parse() {
        Matcher matcher = getCustomDelimiterMatcher();
        if (isMatchCustomSplittable(matcher)) {
            return getCustomSplitResult(matcher);
        }

        Integer[] splitTextToInteger = splitTextToInteger(splitDefaultText());
        Integer result = sumAll(splitTextToInteger);
        return new Result(result);
    }

    private Matcher getCustomDelimiterMatcher() {
        return Pattern.compile("//(.)\n(.*)")
                .matcher(text);
    }

    private Result getCustomSplitResult(Matcher matcher) {
        String customDelimiter = String.format("\\%s", matcher.group(1));
        String[] group = matcher.group(2).split(customDelimiter);
        return new Result(sumAll(splitTextToInteger(group)));
    }

    private boolean isMatchCustomSplittable(Matcher matcher) {
        return matcher.find();
    }

    private boolean isTextEmpty(String text) {
        return text == null ||
                text.isEmpty();
    }

    private String[] splitDefaultText() {
        return text.split(DEFAULT_REGEX);
    }

    private Integer[] splitTextToInteger(String[] group) {
        return Arrays.stream(group)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private Integer sumAll(Integer[] splitText) {
        return Arrays.stream(splitText)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
