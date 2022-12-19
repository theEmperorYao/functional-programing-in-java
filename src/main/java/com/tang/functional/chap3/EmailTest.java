//package com.tang.functional.chap3;
//
//import com.tang.functional.fpinjava.common.Function;
//
//import java.util.regex.Pattern;
//
///**
// * @Classname EmailTest
// * @Description
// * @Date 2022/12/18 22:32
// * @Author by tangyao
// */
//
//interface Result {
//
//}
//
//class Success implements Result {
//
//}
//
//class Failure implements Result {
//    private final String errorMessage;
//
//    public Failure(String errorMessage) {
//        this.errorMessage = errorMessage;
//    }
//
//    public String getErrorMessage() {
//        return errorMessage;
//    }
//}
//
//interface Executable {
//    void exec();
//}
//
//
//public class EmailTest {
//
//    final static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
//    final Function<String, Boolean> emailChecker = s -> emailPattern.matcher(s).matches();
//
//    final static Function<String, Result> emailChecker2 = s -> {
//        if (s == null) {
//            return new Failure("email must not be null");
//        } else if (s.length() == 0) {
//            return new Failure("email must not be empty");
//        } else if (emailPattern.matcher(s).matches()) {
//            return new Success();
//        } else {
//            return new Failure("email" + s + " is invalid");
//        }
//    };
//
//    final static Function<String, Result> emailChecker3 = s ->
//            s == null
//                    ? new Failure("email must not be null")
//                    : s.length() == 0
//                    ? new Failure("email must not be empty")
//                    : emailPattern.matcher(s).matches()
//                    ? new Success()
//                    : new Failure("email " + s + " is invalid.");
//
//    static Executable validate(String s) {
//        Result result = emailChecker3.apply(s);
//        return (result instanceof Success)
//                ? () -> sendVerificationMail(s)
//                : () -> logError(((Failure) result).getErrorMessage());
//    }
//
//    public static void main(String[] args) {
//        EmailTest emailTest = new EmailTest();
////        emailTest.testMail2("");
//
////        emailTest.testMail3("");
////        emailTest.testMail3(null);
////        emailTest.testMail3("1013654193@qq.com");
//
//        validate(null).exec();
//        validate("").exec();
//        validate("1013654193@qq.com").exec();
//
//    }
//
//    void testMail3(String email) {
//        Result result = emailChecker2.apply(email);
//        if (result instanceof Success) {
//            sendVerificationMail(email);
//        } else {
//            Failure result1 = (Failure) result;
//            logError(result1.getErrorMessage());
//        }
//    }
//
//
//    void testMail2(String email) {
//        if (emailChecker.apply(email)) {
//            sendVerificationMail(email);
//        } else {
//            logError("email" + email + "is invalid");
//        }
//    }
//
//    void testMail(String email) {
//        if (emailPattern.matcher(email).matches()) {
//            sendVerificationMail(email);
//        } else {
//            logError("email" + email + "is invalid");
//        }
//    }
//
//    private static void logError(String s) {
//        System.out.println("errormessage logged: " + s);
//    }
//
//    public static void sendVerificationMail(String email) {
//        System.out.println("Error message logged: " + email);
//
//    }
//
//}
