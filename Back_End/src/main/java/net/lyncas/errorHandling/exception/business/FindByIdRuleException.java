package net.lyncas.errorHandling.exception.business;

import net.lyncas.errorHandling.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FindByIdRuleException extends BaseRuntimeException {
    private static final String KEY = "findById.rule";

    public FindByIdRuleException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
