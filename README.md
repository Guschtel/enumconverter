# EnumConverter

This repository demonstrates, that an enum field with a column definition with length of 1 cannot be persisted with Hibernate 6
when using the automatic Enum conversion provided by jakarta.persistence.Enumerated with jakarta.persistence.EnumType#STRING.
See TestEntity#singleChar an SinglecharEnum

This is a reproducer for https://hibernate.atlassian.net/jira/software/c/projects/HHH/issues/HHH-17106?filter=reportedbyme

The failing example uses
- EnumJunitTestCase.enumTestFailsWithEnumConverter
- TestEntity
- TestRepository

We also provide a simple workaround by using a simple AttributeConverter, that converts an enum to a Character.
This is showcased with
- EnumJunitTestCase.enumTestOkWithCustomConverter
- TestWithConverterEntity
- TestWithConverterRepository
