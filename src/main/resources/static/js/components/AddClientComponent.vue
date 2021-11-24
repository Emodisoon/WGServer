<template>

  <v-form class="mx-12 text-center">
    <v-card-title >Добавить устройство</v-card-title>
    <v-container>
      <v-row>
        <v-col
            cols="12"
            md="4"
        >
          <v-text-field
              v-model="name"
              label="Название"
              required
          ></v-text-field>
        </v-col>

        <v-col
            cols="12"
            md="4"
        >
          <v-text-field
              v-model="ip"
              :counter="15"
              label="IP-адресс"
              required
          ></v-text-field>
        </v-col>

        <v-col
            cols="12"
            md="4"
        >
          <v-text-field
              v-model="description"
              label="Описание"
              required
          ></v-text-field>
        </v-col>
      </v-row>
      <v-col
          class="text-center"
          cols="12"
      >
      <v-btn
          elevation="2"
          large
          outlined
          @click="save()"
      >Добавить
      </v-btn>
      </v-col>
    </v-container>

  </v-form>
</template>

<script>
import {mapActions} from "vuex";

export default {
  data() {
    return {
      name: '',
      ip: '',
      description: ''
    }
  },
  methods:{
    ...mapActions(['addClientAction']),
    save(){
      let client = {name: this.name,
        localIp: this.ip,
        description: this.description
      };
      this.addClientAction(client)

      this.name = '';
      this.ip = '';
      this.description = '';
    }
  }
}
</script>

<style scoped>

</style>