import Vue from 'vue'
import VueResource from 'vue-resource'
import '@babel/polyfill'
import router from "./router/router";
import store from 'store.js'
import vuetify from "./plugins/vuetify";
import App from 'components/App.vue'
import * as VueGoogleMaps from 'vue2-google-maps'

Vue.use(VueResource)
Vue.use(VueGoogleMaps, {
    load: {
        key: 'AIzaSyAxc3UFlFudcsufNLZSGd4X9z1DshZ2kdo',
        libraries: 'places',
    },
    installComponents: true
})

new Vue({
    el: '#app',
    vuetify,
    store,
    router,
    render: a=> a(App)
})






