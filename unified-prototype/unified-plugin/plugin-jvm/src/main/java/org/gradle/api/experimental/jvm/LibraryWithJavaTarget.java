package org.gradle.api.experimental.jvm;

import org.gradle.api.Action;
import org.gradle.api.experimental.common.LibraryDependencies;
import org.gradle.api.tasks.Nested;
import org.gradle.declarative.dsl.model.annotations.Configuring;
import org.gradle.declarative.dsl.model.annotations.Restricted;

/**
 * A library that is built for a single Java version.
 */
@Restricted
public interface LibraryWithJavaTarget extends HasJavaTarget {
    @Nested
    LibraryDependencies getDependencies();

    @Configuring
    default void dependencies(Action<? super LibraryDependencies> action) {
        action.execute(getDependencies());
    }
}
