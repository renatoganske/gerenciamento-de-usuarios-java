package net.lyncas.errorHandling.dto;

public class ErrorDto {

    private String key;
    private String message;

    public ErrorDto(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
