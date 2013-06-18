package com.ak.sample

class FirstFilters {
    /**
     * Test filter to verify return false stops the filter chain
     */
    def filters = {
        carListFirst(controller:'car', action:'list') {
            before = {
                if(params.firstFilter){
                    redirect(uri: 'http://google.com')
                    return false
                }
            }
        }
    }
}
