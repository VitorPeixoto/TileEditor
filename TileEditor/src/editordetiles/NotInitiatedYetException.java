package editordetiles;

/**
 *
 * @author Peixoto
 */
class NotInitiatedYetException extends Exception {
    
    public NotInitiatedYetException() {
        super("Class was not initiated yet");
    }
    
    public NotInitiatedYetException(String message) {
        super(message);
    }
}
