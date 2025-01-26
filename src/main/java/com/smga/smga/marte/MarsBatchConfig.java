package com.smga.smga.marte;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class MarsBatchConfig {


    private JobRepository jobRepository;
    private PlatformTransactionManager transactionManager;


    public MarsBatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Job marsDataProcessingJob(Step step1) {
        return new JobBuilder("marsDataProcessingJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(ItemReader<SensorData> reader,
                      ItemProcessor<SensorData, ProcessedSensorData> processor,
                      ItemWriter<ProcessedSensorData> writer) {
        return new StepBuilder("step1", jobRepository)
                .<SensorData, ProcessedSensorData>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}



