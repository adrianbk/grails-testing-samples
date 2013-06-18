package com.ak.sample

import geb.spock.GebSpec
import geb.Page
import com.ak.sample.pages.CarListPage

class CarFilterSpec extends GebSpec {

    def 'When filters are applied then I should be arrive at the expected page'() {

        when:
        go "car/list${params}"

        then:
        at expectedPage

        where:
        scenario                         | params                                | expectedPage
        'no filters'                     | ''                                    | CarListPage
        'firstOnly'                      | '?firstFilter=true'                   | GoogleHomePage
        'secondOnly'                     | '?secondFilter=true'                  | FacebookPage
        'bothShouldApply but first wins' | '?firstFilter=true&secondFilter=true' | GoogleHomePage
        'malicious double redirect'      | '?malicious=true'                     | ErrorPage

    }
}
class GoogleHomePage extends Page {
    static url = 'http://google.com'
    static at = { title.contains("oogle") }
}

class FacebookPage extends Page {
    static url = 'http://facebok.com'
    static at = { title.contains("acebook") }
}

class ErrorPage extends Page {
    static at = {title.contains('rror')}
}