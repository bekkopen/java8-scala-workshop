package no.bekk.java.examples;

import junit.framework.TestCase;
import org.junit.Test;

public class ScopeAndClosuresTest extends TestCase {

    @Test
    public void testScopeAndClosure() {
        ScopeAndClosures scopeExample = new ScopeAndClosures();
        scopeExample.scope();
        scopeExample.closure();
    }
}
