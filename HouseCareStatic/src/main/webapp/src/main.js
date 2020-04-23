/*!
 *
 * Angle - Bootstrap Admin Template
 *
 * Version: 4.7.1
 * Author: @themicon_co
 * Website: http://themicon.co
 * License: https://wrapbootstrap.com/help/licenses
 *
 */

import Vue from 'vue';
import BootstrapVue from 'bootstrap-vue';
import VueI18Next from '@panter/vue-i18next';


import './vendor.js'

import App from './App.vue'
import router from './router'
import i18next from './i18n.js';
import store from './store'

Vue.config.productionTip = false

Vue.use(BootstrapVue);
Vue.use(VueI18Next);

const i18n = new VueI18Next(i18next);

Vue.filter("formatMoney", function(value) {
    Number.prototype.formatMoney = function(n, x, s, c) {
        var re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\D' : '$') + ')',
            num = this.toFixed(Math.max(0, ~~n));

        return (c ? num.replace('.', c) : num).replace(new RegExp(re, 'g'), '$&' + (s || ','));
    };
    if (value) {
        return value.formatMoney(2, 3, '.', ',')
    }else{
        return 0;
    }

});

new Vue({
    i18n,
    router,
    store,
    render: h => h(App)
}).$mount('#app')