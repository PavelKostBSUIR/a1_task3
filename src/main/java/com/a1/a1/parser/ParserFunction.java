package com.a1.a1.parser;

import java.util.List;

public interface ParserFunction<E> {
    E parse(List<String> fields);
}
