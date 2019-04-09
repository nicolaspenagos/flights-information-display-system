package customsExceptions;

@SuppressWarnings("serial")
public class NoSortedElementsBinarySearchException extends Exception{
	public NoSortedElementsBinarySearchException() {
		super("You must order the flights by gate first (BinarySearching)");
	}
}
