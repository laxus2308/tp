package jarvis.model;

import java.util.List;
import java.util.function.Predicate;

import jarvis.commons.util.StringUtil;

/**
 * Tests that a {@code Task}'s {@code Description} matches any of the keywords given.
 */
public class DescContainsKeywordsPredicate implements Predicate<Task> {
    private final List<String> keywords;

    public DescContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Task task) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(task.getDesc().taskDesc, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DescContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((DescContainsKeywordsPredicate) other).keywords)); // state check
    }
}
