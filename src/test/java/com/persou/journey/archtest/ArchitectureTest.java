package com.persou.journey.archtest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class ArchitectureTest {

    @Test
    void domainShouldNotDependOnAdapters() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.persou.journey.employer.entities");

        ArchRuleDefinition.noClasses()
            .that().resideInAPackage("..entities..")
            .should().dependOnClassesThat().resideInAnyPackage("..datasources..", "..transportlayers..")
            .check(importedClasses);
    }

}
