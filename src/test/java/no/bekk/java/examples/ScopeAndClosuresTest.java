package no.bekk.java.examples;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ScopeAndClosuresTest {

    @Test
    public void testScopeAndClosure() {
        ScopeAndClosures scopeExample = new ScopeAndClosures();
        scopeExample.scope();
        scopeExample.closure();
    }
}
