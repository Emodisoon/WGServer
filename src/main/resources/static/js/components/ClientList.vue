<template>
  <div>
    <v-text-field
        v-model="search"
        label="Поиск"
        required
    ></v-text-field>

  <v-layout align-content-space-around justify-start column>

    <client-row v-for="client in searchedClients" :key="client.id" :clients="sortedClients" :client="client"/></v-layout>
  </div>
</template>

<script>
import ClientRow from "components/ClientRow.vue";
import {mapGetters} from 'vuex'
export default {
  computed:    mapGetters(['sortedClients']),
  components:{
    ClientRow,
  },
  created() {
    this.clients = this.sortedClients;
    this.searchedClients = this.clients;

  },
  data(){
    return{
      search: '',
      clients: [],
      searchedClients: []
    }
  },
  watch: {
    search: function (newString, oldString){
      if(newString==="")
      {
        this.searchedClients = this.clients;
      }
      else {
        this.searchedClients = [];
        for (let i = 0; i < this.clients.length; i++) {
          if (String(this.clients[i].id) === newString || this.clients[i].name.indexOf(newString)>-1)  {
            this.searchedClients.push(this.clients[i]);
          }
        }
      }
    }
  }

}
</script>

<style scoped>

</style>