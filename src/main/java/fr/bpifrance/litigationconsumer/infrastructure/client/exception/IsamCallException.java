package fr.bpifrance.litigationconsumer.infrastructure.client.exception;

public class IsamCallException extends RuntimeException {

  private static final long serialVersionUID = 2852570058225677725L;

  public IsamCallException(final String message) {
    super(message);
  }

  public IsamCallException(final String message, final Throwable throwable) {
    super(message, throwable);
  }
}
