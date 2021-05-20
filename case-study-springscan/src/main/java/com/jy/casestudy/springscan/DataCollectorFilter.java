package com.jy.casestudy.springscan;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;

public class DataCollectorFilter extends AbstractTypeHierarchyTraversingFilter {

    private final Class<? extends Annotation> annotationType;

    private final boolean considerMetaAnnotations;

    public DataCollectorFilter(Class<? extends Annotation> annotationType, boolean considerMetaAnnotations, boolean considerInterfaces) {
        super(annotationType.isAnnotationPresent(Inherited.class), considerInterfaces);
        this.annotationType = annotationType;
        this.considerMetaAnnotations = considerMetaAnnotations;
    }

    public DataCollectorFilter(Class<? extends Annotation> annotationType, boolean considerMetaAnnotations) {
        this(annotationType, considerMetaAnnotations, false);
    }

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return super.match(metadataReader, metadataReaderFactory);
    }

    @Override
    protected boolean matchSelf(MetadataReader metadataReader) {
        AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
        return metadata.hasAnnotation(annotationType.getName()) ||
            considerMetaAnnotations && metadata.hasMetaAnnotation(annotationType.getName());
    }

    @Override
    protected Boolean matchSuperClass(String superClassName) {
        return hasAnnotation(superClassName);
    }

    @Override
    protected Boolean matchInterface(String interfaceName) {
        return hasAnnotation(interfaceName);
    }

    protected Boolean hasAnnotation(String typeName) {
        if (Object.class.getName().equals(typeName)) {
            return false;
        } else if (typeName.startsWith("java")) {
            try {
                Class<?> clazz = ClassUtils.forName(typeName, getClass().getClassLoader());
                return (considerMetaAnnotations ? AnnotationUtils.getAnnotation(clazz, annotationType) :
                    clazz.getAnnotation(annotationType)) != null;
            } catch (Throwable ex) {
                logger.error("", ex);
            }
        }
        return null;
    }
}
