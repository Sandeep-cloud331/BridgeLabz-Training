package com.example.fundoo_notes.batch;

import com.example.fundoo_notes.dto.imprt.NoteImportRow;
import com.example.fundoo_notes.entity.Note;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;

import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class NoteImportJobConfig {
    @Bean
    public Step importNotesStep(
            JobRepository jobRepository,
            PlatformTransactionManager txManager,
            NoteExcelReader reader,
            NoteImportProcessor processor,
            NoteImportWriter writer) {
        return new StepBuilder(
                "importNotesStep",
                jobRepository)
                .<NoteImportRow, Note>chunk(
                        100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .transactionManager(txManager)
                .build();
    }
    @Bean
    public Job importNotesJob(
            JobRepository jobRepository,
            Step importNotesStep) {
        return new JobBuilder(
                "importNotesJob",
                jobRepository)
                .start(importNotesStep)
                .build();
    }
}

