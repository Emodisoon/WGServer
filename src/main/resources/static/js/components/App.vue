<template>
  <v-app>
    <my-header/>

    <v-main  class="mt-10 mx-10">
      <v-container fluid>
        <router-view class="mx-10 px-10"></router-view>
      </v-container>
    </v-main>

    <my-footer/>
  </v-app>
</template>

<script>
import myHeader from "components/MyHeader.vue"
import myFooter from "components/MyFooter.vue"
import {mapMutations} from "vuex";

export default {

  created(){
    this.$resource('/client').get().then(result =>
        result.json().then(
            data => data.forEach(client => this.addClient(client))
            
        ));
  },
  data(){
    return{

    }
  },
  methods:{
    ...mapMutations(['addClient'])
  },
  components:{
    myHeader,
    myFooter
  }

}
</script>

<style scoped>

</style>