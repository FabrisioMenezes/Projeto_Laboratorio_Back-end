package unit.grupo3.Biolab.service.error;

public class ApiError {

    private String error;

    public ApiError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
