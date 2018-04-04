package com.prussia.test.myspring.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;

public class CSVTest {

	@Test
	public void testApacheCommonCSV() throws Exception {
		String file = this.getClass().getResource("test.csv").getFile();
		Reader in = new FileReader(file);
		List<CSVRecord> records = CSVFormat.DEFAULT
											.withFirstRecordAsHeader()
											.withAllowMissingColumnNames().parse(in)
											.getRecords();
		for (CSVRecord record : records) {
			String columnOne = record.get(0);
			String columnTwo = record.get(1);
		}
		Assert.assertSame(5, records.size());

	}
}
