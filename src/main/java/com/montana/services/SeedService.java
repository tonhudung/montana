package com.montana.services;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by alex_to on 29/10/2015.
 */
public interface SeedService {
    void seed(String source, String dest) throws IOException, ParseException;

    void testTx() throws Exception;
}
