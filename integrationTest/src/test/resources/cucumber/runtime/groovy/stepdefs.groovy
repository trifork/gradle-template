package cucumber.runtime.groovy

import static groovy.util.GroovyTestCase.assertEquals

this.metaClass.mixin(cucumber.runtime.groovy.Hooks)
this.metaClass.mixin(cucumber.runtime.groovy.EN)

Given(~"^I have (\\d+) pebbles in my hand") { int p ->
    pebbleCount(pebbles)
}

Then(~"^I pick up (\\d+) more pebbles") { int p ->
    addPebbles(p)
}

Then(~"^there are (\\d+) pebbles in my hand") { int p ->
    assertPebbleCount(pebbles)
}

World {
    new CustomWorld();
}

class CustomWorld {

    private def pebbles = 0

    def addPebbles(n) {
        pebbles += n
    }

    def pebbleCount(n) {
        pebbles = n
    }

    def assertPebbleCount(n) {
        assertEquals(n, pebbles)
    }
}