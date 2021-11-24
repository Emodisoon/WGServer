<template>
  <v-layout align-content-space-around justify-start column>
    <v-card class="mx-auto" width="550">
      <v-card-title class="text-center mx-auto">
        Устройство {{client.name}}
      </v-card-title>

      <v-card-text>
        <v-row
            align="center"
            class="mx-0"
        >


        <div>Ip: {{client.localIp}}</div>
        </v-row>
        <v-row align="center"
               class="mx-0"
        >
          <div id="StatusText">Status: {{status}}</div>
        </v-row>
      </v-card-text>

      <v-card-actions>
        <v-btn @click="checkOnline">Обновить статус</v-btn>
        <v-btn @click="getLocation">Получить локакцию</v-btn>
        <v-btn >Action2</v-btn>
      </v-card-actions>
    </v-card>

    <h1 v-if="showMap" class="mt-5 mx-auto">Локация</h1>
    <h2 v-if="lat===0 && lng===0" class="text-center" style="color: red"> Похоже что на устройсте отключен GPS и мы не можем получить его координаты.</h2>
    <GmapMap
        v-if="showMap"
        :center="{lat, lng}"
        :zoom="15"
        style="width: 550px; height: 400px"
        class="mt-5 mx-auto"
    >
      <GmapMarker ref="myMarker"
                  :clickable="false"
                  :draggable="false"
                  :position="google && new google.maps.LatLng(lat, lng)" />
    </GmapMap>


  </v-layout>

</template>
<script>
import {gmapApi} from 'vue2-google-maps'
import {mapGetters} from 'vuex'
import Vue from "vue";
export default {
  computed: {
    ...mapGetters(['getClientById']),
    google: gmapApi
  },
  data(){
    return {
      client:null,
      status:"unknown",
      lat: -1,
      lng: -1,
      showMap: false,
    }
  },
  created() {
    this.client = this.$store.getters.getClientById(this.$route.params.id)
    },
  mounted() {
    this.checkOnline();
    },
  methods:{
    async checkOnline() {

      document.getElementById("StatusText").style.color = "gray";
      this.status = "sending request..."
      const result = await Vue.http.post('/api/checkOnline/' + this.client.id);
      if(result.bodyText==='Ok'){
      document.getElementById("StatusText").style.color = "green";
      this.status = "Online"
      }else{
        document.getElementById("StatusText").style.color = "red";
        this.status = "Offline"
      }
    },
    async getLocation() {
      this.showMap = false;
      const result = await Vue.http.post('/api/getLocation/' + this.client.id);
      let coords = result.bodyText
      let index = coords.indexOf(" ");
      this.lat = Number(coords.slice(0, index));
      this.lng = Number(coords.slice(index, coords.length))
      this.showMap = true;

    }




  }
}
</script>

<style scoped>

</style>