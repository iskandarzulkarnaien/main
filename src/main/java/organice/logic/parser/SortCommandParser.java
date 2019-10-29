package organice.logic.parser;

import organice.logic.commands.SortCommand;
import organice.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    public static final String ORGAN_EXPIRY_DATE = "expiry";
    public static final String PRIORITY = "priority";
    public static final String SUCCESS_RATE = "rate";
    public static final String MESSAGE_INVALID_INPUTS = "The input should be 'expiry', 'priority' or 'rate'.";

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String userInput) throws ParseException {
        userInput = userInput.trim();
        if (!(userInput.equalsIgnoreCase(ORGAN_EXPIRY_DATE)
                || userInput.equalsIgnoreCase(PRIORITY) || userInput.equalsIgnoreCase(SUCCESS_RATE))) {
            throw new ParseException(MESSAGE_INVALID_INPUTS);
        }
        return new SortCommand(userInput);
    }
}