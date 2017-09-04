package com.onenine.template.processor;

import com.google.auto.service.AutoService;
import com.onenine.template.annotations.InitMethod;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * Created by xuchunlei on 2017/9/4.
 */

@AutoService(Processor.class)
public class TemplateProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        throw new RuntimeException("sjdfsjdlkf");
//        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> types = new LinkedHashSet<>();
        types.add(InitMethod.class.getCanonicalName());
        return types;
    }


}
