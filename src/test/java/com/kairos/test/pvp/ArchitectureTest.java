package com.kairos.test.pvp;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

class ArchitectureTest {

    private static final String SPRING = "Spring";
    private static final String INFRASTRUCTURE = "Infrastructure";
    private static final String DOMAIN = "Domain";
    private static final String APPLICATION = "Application";

    private final JavaClasses javaClasses = new ClassFileImporter()
        .withImportOption(new ImportOption.DoNotIncludeTests())
        .importPackages(this.getClass().getPackage().getName());

    @Test
    void testDependecies() {
        Architectures.layeredArchitecture().consideringOnlyDependenciesInLayers().withOptionalLayers(true)
            .layer(SPRING).definedBy("org.springframework..")
            .layer(DOMAIN).definedBy("..domain..")
            .layer(INFRASTRUCTURE).definedBy("..infrastructure..")
            .layer(APPLICATION).definedBy("..application..")

            .whereLayer(DOMAIN).mayOnlyAccessLayers(DOMAIN, SPRING)
            .whereLayer(APPLICATION).mayOnlyAccessLayers(SPRING, APPLICATION, DOMAIN)

            .check(javaClasses);
    }

}
