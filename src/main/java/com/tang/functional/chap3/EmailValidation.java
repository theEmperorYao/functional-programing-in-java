package com.tang.functional.chap3;


import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import static com.tang.functional.chap3.Case.*;

import static com.tang.functional.chap3.Result.failure;
import static com.tang.functional.chap3.Result.success;

/**
 * @Title: EmailValidation
 * @Description:
 * @author: tangyao
 * @date: 2022/12/19 15:19
 * @Version: 1.0
 */

public class EmailValidation {
    final static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
//    final static Function<String, Result<String>> emailChecker = s -> {
//        if (s == null) {
//            return Result.failure("email must not be null");
//        } else if (s.length() == 0) {
//            return Result.failure("email must not be empty");
//        } else if (emailPattern.matcher(s).matches()) {
//            return Result.success(s);
//        } else {
//            return Result.failure("email" + s + " is invalid");
//        }
//    };

    static Effect<String> success = s ->
            System.out.println("Mail sent to " + s);

    static Effect<String> failure = s ->
            System.out.println("Error message logged: " + s);

    public static void main(String[] args) {
        emailChecker.apply("this.is@my.email").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@acme.com").bind(success, failure);
    }

    static Function<String, Result<String>> emailChecker = s ->
            match(
                    mcase(() -> success(s)),
                    mcase(() -> s == null, () -> failure("email must not be null")),
                    mcase(() -> s.length() == 0, () -> failure("email must not be empty")),
                    mcase(() -> !emailPattern.matcher(s).matches(), () -> failure("email " + s + "is invalid."))
            );


}