package com.smga.smga.marte;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilderSupport;
import org.springframework.batch.core.step.builder.StepBuilderSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MarsBatchConfig {

    @Bean
    public Job marsDataProcessingJob(Step step1) {
        return new JobBuilderSupport<>("marsDataProcessingJob")
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(ItemReader<SensorData> reader,
                      ItemProcessor<SensorData, ProcessedSensorData> processor,
                      ItemWriter<ProcessedSensorData> writer) {
        return new StepBuilderSupport<>("step1")
                .<SensorData, ProcessedSensorData>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}



