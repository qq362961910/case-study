package com.jy.casestudy.springscan;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class ClassScanner {

    private static final String RESOURCE_PATTERN = "/**/*.class";

    private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    public static Set<String> scan(TypeFilter[] entityTypeFilters, String[] packagesToScan) {
        Set<String> entityClassNames = new TreeSet<>();
        try {
            for (String pkg : packagesToScan) {
                String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;
                Resource[] resources = resourcePatternResolver.getResources(pattern);
                MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        MetadataReader reader = readerFactory.getMetadataReader(resource);
                        String className = reader.getClassMetadata().getClassName();
                        if (matchesEntityTypeFilter(reader, readerFactory, entityTypeFilters)) {
                            entityClassNames.add(className);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Failed to scan classpath for unlisted classes", ex);
        }
        return entityClassNames;
    }

    private static boolean matchesEntityTypeFilter(MetadataReader reader, MetadataReaderFactory readerFactory, TypeFilter[] entityTypeFilters) throws IOException {
        if (entityTypeFilters != null) {
            for (TypeFilter filter : entityTypeFilters) {
                if (filter.match(reader, readerFactory)) {
                    return true;
                }
            }
        }
        return false;
    }
}
