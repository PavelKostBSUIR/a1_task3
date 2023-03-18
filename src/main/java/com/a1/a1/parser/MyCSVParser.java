package com.a1.a1.parser;

import com.a1.a1.entity.dto.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCSVParser {
    public static List<PostParserDto> getPosts(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new PostParserDto(Long.valueOf(fields.get(0)), Date.valueOf(refactorDate(fields.get(2))), Date.valueOf(refactorDate(fields.get(3))), Long.valueOf(fields.get(5)), fields.get(9), fields.get(9))));
    }

    public static List<CurrencyParserDto> getCurrencies(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new CurrencyParserDto(fields.get(8))));
    }

    public static List<ApplicationParserDto> getApplications(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new ApplicationParserDto(fields.get(0))));
    }

    public static List<DepartmentParserDto> getDepartments(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new DepartmentParserDto(fields.get(4))));
    }

    public static List<BunParserDto> getBuns(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new BunParserDto(fields.get(6))));
    }

    public static List<UserParserDto> getUsers(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new UserParserDto(fields.get(1), Boolean.valueOf(fields.get(2)), fields.get(3), fields.get(0), fields.get(4))));
    }

    public static List<PostItemParserDto> getPostItems(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new PostItemParserDto(Long.valueOf(fields.get(1)), Long.valueOf(fields.get(0)), fields.get(4))));
    }

    public static List<ItemParserDto> getItems(File file, String separator) throws IOException {
        return parse(file, separator, (fields -> new ItemParserDto(fields.get(4), Double.valueOf(fields.get(7).replace(",", ".")), fields.get(8), fields.get(6))));
    }

    private static <E> List<E> parse(File file, String separator, ParserFunction<E> parserFunction) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        return skipStart(reader).map(
                s -> {
                    List<String> fields = getFields(s, separator);
                    return parserFunction.parse(fields);
                }
        ).collect(Collectors.toList());
    }

    private static Stream<String> skipStart(BufferedReader reader) {
        return reader.lines().skip(2);
    }

    private static List<String> getFields(String s, String separator) {
        return Arrays.stream(s.split(separator)).map(String::trim).collect(Collectors.toList());
    }

    private static String refactorDate(String date) {
        List<String> list = Arrays.stream(date.split("\\.")).collect(Collectors.toList());
        Collections.reverse(list);
        return list.get(0) + "-" + list.get(1) + "-" + list.get(2);
    }
}
