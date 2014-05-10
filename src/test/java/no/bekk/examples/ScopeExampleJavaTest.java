package no.bekk.examples;

import junit.framework.TestCase;
import org.junit.Test;

public class ScopeExampleJavaTest extends TestCase {

    @Test
    public void testScope() {
        ScopeExampleJava scopeExample = new ScopeExampleJava();
        scopeExample.scope();
        scopeExample.closure();
    }
}
