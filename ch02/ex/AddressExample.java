package ch02.ex;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Copyright 2005 Bytecode Pty Ltd.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AddressExample {

    private static final String ADDRESS_FILE = "ch02/ex/address.csv";

    // to run this, put 'opencsv-4.2.jar' into 'ch02/ex/'
    // change dir to '~/gits/java_se_9_for_the_impatient/',
    // javac -cp '.:./ch02/ex/opencsv-4.2.jar' ch02/ex/AddressExample.java
    // java -cp '.:/Users/yuzhao/.m2/repository/org/apache/commons/commons-lang3/3.4/commons-lang3-3.4.jar:./ch02/ex/opencsv-4.2.jar' ch02/ex/AddressExample
    public static void main(String[] args) throws IOException {

        CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println("Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");
        }

        // Try writing it back out as CSV to the console
        CSVReader reader2 = new CSVReader(new FileReader(ADDRESS_FILE));
        List<String[]> allElements = reader2.readAll();
        StringWriter sw = new StringWriter();
        CSVWriter writer = new CSVWriter(sw);
        writer.writeAll(allElements);

        System.out.println("\n\nGenerated CSV File:\n\n");
        System.out.println(sw.toString());


    }
}
