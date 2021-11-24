import Vue from 'vue'
import VueRouter from 'vue-router'
import ClientList from 'components/ClientList.vue'
import Client from 'components/Client.vue'
import ClientTable from 'components/ClientTable.vue'
import AddClient from 'components/AddClientComponent.vue'

const routes = [
    {path: '/', component: ClientTable},
    {path: '/add', component: AddClient},
    {path: '/delete', component: ClientList},
    {path: '/clients/:id', component: Client, name: 'client'},
    {path: '*', component: ClientList},
]

Vue.use(VueRouter)
export default new VueRouter({
    mode: 'history',
    routes
})