package org.lockdog.calculator;

public interface InputOutput {
    /**
     * Read next input line
     *
     * @return
     */
    String readNext();

    /**
     * Do we have some input line? (exit command means no)
     * @return
     */
    Boolean hasNext();

    /**
     * Print back the response
     * @param s
     */
    void print(String s);
}
