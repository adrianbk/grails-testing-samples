package com.ak.sample

class SecondFilters {

    /**
     * Test filter to verify return false stops the filter chain
     */
    def filters = {
        carListSecond(controller: 'car', action: 'list') {
            before = {
                if (params.secondFilter) {
                    redirect(uri: 'http://facebook.com')
                    return false
                }
            }

        }

        malicious(controller: 'car', action: 'list') {
            before = {
                if (params.malicious) {
                    redirect(uri: 'http://facebook.com')

                    redirect(url: 'www.wigput.com')
                }
            }
        }
    }
}
