package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.MainWindow;

/**
 * Abstraction of the bye command for exiting the program.
 */
class ByeCommand extends Command {
    /**
     * Constructor of the List command.
     * Calls its parent constructor then sets its commandType enum.
     *
     * @param args String array of arguments.
     */
    public ByeCommand(String[] args) {
        super(args);
        commandType = Commands.BYE;
    }

    /**
     * Displays the program exit message.
     *
     * @param tasks TaskList of tasks to use.
     * @param ui MainWindow to use for displaying command output.
     * @param storage Storage for WritableCommands to execute write-to-disk operations.
     */
    @Override
    public void run(TaskList tasks, MainWindow ui, Storage storage) {
        ui.showMessage(" Bye. Hope to see you again soon!");
    }

    /**
     * Checks that there are no other arguments provided.
     *
     * @param tasks TaskList of tasks to use.
     * @param ui MainWindow to use for displaying command output.
     * @param storage Storage for WritableCommands to execute write-to-disk operations.
     * @throws DukeInvalidArgumentException If there are other arguments.
     */
    @Override
    void validate(TaskList tasks, MainWindow ui, Storage storage) throws DukeInvalidArgumentException {
        if (commandArgs.length >= 1) {
            throw new DukeInvalidArgumentException(
                    "Encountered extraneous arguments after bye command",
                    " ☹  OOPS!!! There shouldn't be anything following 'bye',\n"
                            + " are you sure you wanted to exit?");
        }
    }
}
