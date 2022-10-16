package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileController<Hospital> hospitalFileController = new FileController<>(new HospitalParser());
        String filename = "C:\\Users\\zzzo_\\Downloads\\seoul_hospital_infos.txt";
        List<Hospital> hospitals = hospitalFileController.readLines(filename);

        List<String> sqlStatements = new ArrayList<>();
        for(Hospital hospital : hospitals) {
            sqlStatements.add(hospital.getSqlInsertQuery2());
        }

        String sqlFilename = "seoul_hospitl_insert.sql";
        hospitalFileController.createANewFile(sqlFilename);
        hospitalFileController.writeLines(sqlStatements, sqlFilename);

//        // sql 구문 리스트
//        List<String> sqlStatements = new ArrayList<>();
//        for(Hospital hospital : hospitals){
//            sqlStatements.add(hospital.getSqlInsertQuery());
//        }
    }
}
