package com.example.fundoo_notes.batch;

import com.example.fundoo_notes.dto.imprt.NoteImportRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Iterator;

@Component
public class NoteExcelReader
        implements ItemReader<NoteImportRow> {
    private Iterator<Row> rowIterator;
    private boolean initialized = false;
    private void init() throws Exception {
        FileInputStream fis =
                new FileInputStream(
                        "notes-import.xlsx");
        Workbook workbook =
                new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        rowIterator = sheet.iterator();
        rowIterator.next(); // header
        initialized = true;
    }
    @Override
    public NoteImportRow read()
            throws Exception {
        if (!initialized) init();
        if (!rowIterator.hasNext()) {
            return null;
        }
        Row row = rowIterator.next();
        NoteImportRow item = new NoteImportRow();
        item.setTitle(
                row.getCell(0)
                        .getStringCellValue());
        item.setContent(
                row.getCell(1)
                        .getStringCellValue());
        item.setUserId(
                (int) row.getCell(2)
                        .getNumericCellValue());
        return item;
    }
}
