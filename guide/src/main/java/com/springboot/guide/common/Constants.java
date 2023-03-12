package com.springboot.guide.common;

public class Constants {
    // 커스텀 예외 클래스 예제
    // 10.17 ExceptionClass 열거형 : Constants 라는 상수들을 통합 관리하는 클래스 생성

    public enum ExceptionClass {

        // 커스텀 예외 클래스에서 메세지 내부에 어떤 도메인 문제가 발생했는 지 보여주는 데에 사용

        PRODUCT("Product");

        private String exceptionClass;

        ExceptionClass(String exceptionClass){
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + "Exception. ";
        }
    }

}
