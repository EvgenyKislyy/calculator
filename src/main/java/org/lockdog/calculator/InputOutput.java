package org.lockdog.calculator;

public interface InputOutput {
    /**
     * Read next input line
     *
     * @return
     */
    String readNext();

    /**
     * Do we have some input line?
     * @return
     */
    Boolean hasNext();

    /**
     * Pring back the response
     * @param s
     */
    void print(String s);
}
