/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WebsiteGeneratorTest {
    // static test index.html path
    static String testOutputPath = "src/main/resources/output_files/exercise43_test_index.html";

    @Test
    void genIndexHTML_Lixir_MichaelVuolo() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        Assertions.assertTrue(websiteGenerator.genIndexHTML(testOutputPath, "Lixir", "Michael Vuolo"));
    }
}

