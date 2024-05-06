package com.centurionstudio.exceptions;


public interface ExceptionType {
    String getCode();

    String geType();

    String getSummary();

    enum Business implements ExceptionType {

        CONSTRAINS_VIOLATION("Business constraints violation");

        private String summary;

        Business(String summary) {
            this.summary = summary;
        }

        @Override
        public String getCode() {
            return String.format("B%05d", this.ordinal());
        }

        @Override
        public String geType() {
            return String.format("BUSINESS-%s", this.name());
        }

        @Override
        public String getSummary() {
            return summary;
        }

        public Business summary(String summary) {
            this.summary = summary;
            return this;
        }
    }

    enum Technical implements ExceptionType {

        UNREACHABLE_SERVICE("External service cannot be reached");

        private final String summary;

        Technical(String summary) {
            this.summary = summary;
        }

        @Override
        public String getCode() {
            return String.format("T%05d", this.ordinal());
        }

        @Override
        public String geType() {
            return String.format("TECHNICAL-%s", this.name());
        }

        @Override
        public String getSummary() {
            return summary;
        }

    }
}
