<template>
  <v-card class="my-2">
    <v-card-title>
      ID: {{ client.id }} Name: {{client.name}}
    </v-card-title>
    <v-card-actions >

      <v-btn small text @click="del">
          Удалить
        </v-btn>
    </v-card-actions>

    </v-card>
</template>

<script>

import {mapActions} from "vuex";

export default {
  props:['client', 'clients'],

  methods: {
    ...mapActions(['removeClientAction']),

    del(){
      this.removeClientAction(this.client);
    }
  }
}
</script>

<style scoped>

</style>