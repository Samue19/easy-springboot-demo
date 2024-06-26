package com.samuel.myspringboot.core.condition;

import com.samuel.myspringboot.core.AutoConfiguration;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class MyImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        ServiceLoader<AutoConfiguration> serviceLoader =
                ServiceLoader.load(AutoConfiguration.class);
        List<String> list = new ArrayList<String>();
        for (AutoConfiguration autoConfiguration : serviceLoader) {
            list.add(autoConfiguration.getClass().getName());
        }
        return list.toArray(new String[0]);
    }
}

