import Vue from 'vue'
import Vuex from 'vuex'
import VueResource from 'vue-resource'


Vue.use(Vuex)
Vue.use(VueResource)

export default new Vuex.Store({
    state:{
        clients: []
    },
    getters:{
        sortedClients: state => state.clients.sort((a,b)=>-(a.id - b.id)),

        getClientById: state => id => state.clients.find(client => client.id===id),



    },
    mutations:{
        addClient(state, client){
            state.clients = [
                ...state.clients,
                client
            ]
        },
        updateClient(state, client){
            const updateIndex = state.clients.findIndex(item => item.id ===client.id)
            state.clients = [
                ...state.clients.slice(0,updateIndex),
                client,
                ...state.clients.slice(updateIndex+1, )
            ]
        },
        removeClient(state, client){
            const updateIndex = state.clients.findIndex(item => item.id ===client.id)
            if(updateIndex>-1){
                state.clients = [
                    ...state.clients.slice(0,updateIndex),
                    ...state.clients.slice(updateIndex+1)
                ]
            }
        }
    },
    actions:{
        async addClientAction({commit}, client){
            const result = await Vue.http.post('/client', client)
            const data = await result.json()
            commit('addClient', data)

        },
        async removeClientAction({commit}, client){
            const result = await Vue.http.delete('/client/'+client.id)
            if(result.ok){
                commit("removeClient", client)
            }
        },
        async updateClientAction({commit}, client){
            const result = await this.$resource('/client{/id}').update({id: this.id}, client)
            const data = await result.json()
            commit('updateClient', data)
        },
    }

})