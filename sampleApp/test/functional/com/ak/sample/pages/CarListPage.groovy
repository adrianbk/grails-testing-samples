package com.ak.sample.pages

import geb.Page

class CarListPage extends Page{
    static url = 'car/list'

    static at = {
        title == 'Car List'
    }

    static content = {

    }
}
